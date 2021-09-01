package danbroid.util.menu.ui

import android.content.Context
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.compositionLocalOf
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import danbroid.util.menu.Menu
import danbroid.util.menu.navRoute

open class MenuContext(
  val id: String,
  val context: Context,
  val navController: NavHostController,
  val snackbarHostState: SnackbarHostState? = null
) {

  companion object {
    var NEXT_ID = 0
  }

  open suspend fun onMenuClicked(menu: Menu): Boolean {
    log.dwarn("onMenuClicked(): $menu")
    menu.onClicked?.also {
      it.invoke(this)
    } ?: run {
      navController.findDestination(menu.id)?.also {
        log.dwarn("FOUND DESTINATION: ${menu.id}")
        navController.navigate(menu.id)
      } ?: run {

        if (navController.graph.hasDeepLink(menu.id.toUri())) {
          log.dwarn("FOUND DEEPLINK: ${menu.id}")
          navController.navigate(menu.id.toUri())
        } else if (menu.isBrowsable) {
          log.dwarn("browsable .. navigating to ${menu.navRoute}")
          navController.navigate(menu.navRoute) //, menuNavOptions)
        } else {
          return false
        }
      }
    }
    return true
  }

}

private val log = danbroid.logging.getLog(MenuContext::class)

val LocalMenuContext =
  compositionLocalOf<MenuContext> { error("No local provided for LocalMenuContext") }
