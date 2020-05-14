package danbroid.util.menu.ui

import android.net.Uri
import android.view.ContextMenu
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.view.iterator
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import danbroid.util.menu.MenuItem
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.R
import danbroid.util.menu.ui.menulist.MenuListFragment
import danbroid.util.menu.ui.menulist.MenuListFragmentDirections

object MenuImplementation {

  @LayoutRes
  var layoutID: Int = R.layout.fragment_menu_list

  var setToolbarTitle: FragmentActivity.(CharSequence) -> Unit = {
    setTitle(it)
  }

  var menuClickHandler: Fragment.(MenuItem) -> Unit = { menu ->
    log.info("onClicked() $menu")

    val navController = findNavController()

    val uri = Uri.parse(menu.id)
    if (navController.graph.hasDeepLink(Uri.parse(menu.id))) {
      navController.navigate(uri)
    } else if (menu.isBrowsable) {
      MenuListFragmentDirections.actionGlobalNavigationMenu(menu.id).also {
        navController.navigate(it)
      }
    }
  }

  var menuContextMenuHandler: Fragment.(MenuItem,ContextMenu, View, ContextMenu.ContextMenuInfo?) -> Unit = {menuItem, contextMenu, _, _ ->
    if (menuItem.contextMenuID != 0){
      requireActivity().menuInflater.inflate(menuItem.contextMenuID,contextMenu)
  /*    contextMenu.iterator().forEach {
        it.setOnMenuItemClickListener {
          log.trace("clicked $it")
          true
        }
      }*/
    }
  }

  lateinit var rootContent: Fragment.() -> MenuItemBuilder
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuImplementation::class.java)
