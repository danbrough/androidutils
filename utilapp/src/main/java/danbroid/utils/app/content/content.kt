package danbroid.utils.app.content

import android.content.Context
import danbroid.utils.app.URI_CONTENT_PREFIX
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.menu
import danbroid.util.menu.rootMenu
import danbroid.utils.app.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
fun rootContent(context: Context) = context.rootMenu<MenuItemBuilder> {
  id = URI_CONTENT_PREFIX
  titleID = R.string.app_name

  menu {
    title = "Menu 1"
  }

  menu {
    title = "Menu 2"
  }
}
