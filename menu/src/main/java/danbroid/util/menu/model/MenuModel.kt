package danbroid.util.menu.model

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import danbroid.util.menu.MenuConfiguration
import danbroid.util.menu.MenuItem
import danbroid.util.menu.MenuNavGraph
import danbroid.util.menu.find
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuModel(fragment: Fragment, val menuID: String) : ViewModel() {

  val context by lazy {
    fragment.requireContext()
  }

  private val _menu = MutableLiveData<MenuItem>()
  val menu: LiveData<MenuItem> = _menu

  private val _children = MutableLiveData<List<MenuItem>>()
  val children: LiveData<List<MenuItem>> = _children

  init {
    log.trace("CREATED MODEL FOR $menuID")
    invalidate(fragment)
  }

  fun invalidate(fragment: Fragment) {
    log.trace("invalidate() $menuID")
    viewModelScope.launch(Dispatchers.IO) {
      val builder = MenuConfiguration.rootMenu.invoke().find(menuID)
          ?: throw IllegalArgumentException("menuID $menuID not found in Configration.rootMenu")
      log.trace("builder: $builder")
      builder.createItem(fragment).also { item ->
        log.debug("created item: $item")
        item.children?.forEach {
          log.trace("child: $it")
        }
        _menu.postValue(item)
        _children.postValue(item.children)
      }
    }.invokeOnCompletion {
      it ?: return@invokeOnCompletion
      log.error(it.message, it)
    }
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

fun Fragment.menuViewModel(id: String = requireArguments().getString(MenuNavGraph.arg.menu)!!): MenuModel =
    MenuModel.createModel(this, id)


private val log = org.slf4j.LoggerFactory.getLogger(MenuModel::class.java)
