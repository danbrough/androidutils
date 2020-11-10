package danbroid.util.menu

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.slf4j.LoggerFactory

object MenuConfiguration {
  private val log = LoggerFactory.getLogger(MenuConfiguration::class.java)

  lateinit var rootMenu: () -> MenuItemBuilder

  var menuClickHandler: Fragment.(MenuItem) -> Unit = { menu ->
    log.trace("onClicked() $menu")

    val navController = findNavController()

    val uri = Uri.parse(menu.id)
    if (navController.graph.hasDeepLink(Uri.parse(menu.id))) {
      log.trace("navigating to deeplink $uri")
      navController.navigate(uri)
    } else if (menu.isBrowsable) {
      log.trace("menu.isBrowsable so navigating to ${menu.id}")
      navController.navigateToMenuID(menu.id)
    } else {
      log.warn("unhandled menu: ${menu.id}")
    }
  }


  var setToolbarTitle: Fragment.(CharSequence) -> Unit = {
    requireActivity().title = it
  }
}


