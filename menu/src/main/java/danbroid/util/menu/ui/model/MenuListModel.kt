package danbroid.util.menu.ui.model

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import danbroid.util.context.singleton
import danbroid.util.menu.ContentManager
import danbroid.util.menu.MenuItem
import danbroid.util.menu.MenuItemBuilder

open class MenuListModel(context: Context, id: String, val builder: MenuItemBuilder) : ViewModel() {

  open val menu: LiveData<MenuItem> =
    context.singleton<ContentManager>()
      .liveItemFlow(id, builder)
      .asLiveData(viewModelScope.coroutineContext)

  init {
    builder.onCreateModel?.invoke(this)
  }

  override fun onCleared() {
    builder.onClearedModel?.invoke(this)
  }

  companion object {
    class NewInstanceFactory(val context: Context, val id: String, val builder: MenuItemBuilder) :
      ViewModelProvider.NewInstanceFactory() {
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