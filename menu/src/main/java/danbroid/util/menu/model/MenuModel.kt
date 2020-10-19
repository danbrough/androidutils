package danbroid.util.menu.model

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import danbroid.util.menu.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MenuModel(fragment: Fragment, val menuID: String) : ViewModel() {

  val context = fragment.requireContext()

  private val _menu = MutableLiveData<MenuItem>()
  val menu: LiveData<MenuItem> = _menu

  private val _children = MutableLiveData<List<MenuItem>>()
  val children: LiveData<List<MenuItem>> = _children

  init {
    log.info("CREATED MODEL FOR $menuID")

    viewModelScope.launch {
      val builder = MenuConfiguration.rootMenu.invoke(menuID).find(menuID)
        ?: throw IllegalArgumentException("menuID $menuID not found in Configration.rootMenu")
      builder.createItem(context).also { item ->
        _menu.value = item
        _children.value = item.children

        builder.onCreate?.invoke(fragment, item, this@MenuModel)

      }
    }
  }

  fun updateItem(item: MenuItem) {
    _menu.postValue(item)
  }

  fun updateChildren(children: List<MenuItem>) {
    _children.postValue(children)
  }

  override fun onCleared() {
    log.warn("onCleared() $menuID")
  }


  companion object {

    class Factory(val fragment: Fragment, val menuID: String) :
      ViewModelProvider.NewInstanceFactory() {
      @Suppress("UNCHECKED_CAST")
      override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MenuModel(fragment, menuID) as T
      }
    }

    @JvmStatic
    fun createModel(fragment: Fragment, menuID: String) =
      ViewModelProvider(fragment, Factory(fragment, menuID))
        .get(menuID, MenuModel::class.java)
  }

}

fun Fragment.menuViewModel(): MenuModel =
  MenuModel.createModel(this, requireArguments().getString(MenuNavGraph.arg.menu)!!)


private val log = org.slf4j.LoggerFactory.getLogger(MenuModel::class.java)
