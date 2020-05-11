package danbroid.menu.ui.model

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import danbroid.menu.ContentManager
import danbroid.menu.MenuItem
import danbroid.menu.MenuItemBuilder
import danbroid.menu.find
import danbroid.util.context.singletons

class MenuListModel(context: Context, val id: String) : ViewModel() {

  lateinit var rootContent: MenuItemBuilder

  val builder: MenuItemBuilder by lazy {
    rootContent.find(id) ?: throw Exception("Failed to find builder: $id")
  }

  val menu: LiveData<MenuItem> =
      context.singletons<ContentManager>().liveItemFlow(id, builder).asLiveData(viewModelScope.coroutineContext)


  class Factory(val context: Context, val id: String) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return MenuListModel(context, id) as T
    }
  }
}


fun Fragment.menuListModel(id: String): MenuListModel =
    ViewModelProvider(this, MenuListModel.Factory(context!!, id)).get(MenuListModel::class.java)

private val log = org.slf4j.LoggerFactory.getLogger(MenuListModel::class.java)
