package danbroid.utils.app.content

import android.content.Context
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.menu
import danbroid.util.menu.rootMenu
import danbroid.utils.app.R
import danbroid.utils.app.URI_CONTENT_PREFIX
import kotlinx.coroutines.ExperimentalCoroutinesApi

private val log = danbroid.logging.getLog("danbroid.utils.app.content")

@ExperimentalCoroutinesApi
fun rootContent(context: Context) = context.rootMenu<MenuItemBuilder> {
  id = URI_CONTENT_PREFIX
  titleID = R.string.app_name

  menu {
    title = "Menu 1"
    onClick = {
      log.debug("clicked menu 1")
    }
  }

  menu {
    title = "Menu 2"
  }
}
