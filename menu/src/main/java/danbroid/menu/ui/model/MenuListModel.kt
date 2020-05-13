package danbroid.menu.ui.model

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import danbroid.menu.ContentManager
import danbroid.menu.MenuItem
import danbroid.menu.MenuItemBuilder
import danbroid.util.context.singletons

open class MenuListModel(context: Context, id: String, builder: MenuItemBuilder) : ViewModel() {
  open val menu: LiveData<MenuItem> =
      context.singletons<ContentManager>().liveItemFlow(id, builder).asLiveData(viewModelScope.coroutineContext)

  companion object {
    class NewInstanceFactory(val context: Context, val id: String, val builder: MenuItemBuilder) : ViewModelProvider.NewInstanceFactory() {
      @Suppress("UNCHECKED_CAST")
      override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MenuListModel(context, id, builder) as T
      }
    }
  }
}


fun Fragment.menuListModel(id: String, builder: MenuItemBuilder): MenuListModel {
  return ViewModelProvider(this, MenuListModel.Companion.NewInstanceFactory(context!!, id, builder))
      .get(id, MenuListModel::class.java)
}