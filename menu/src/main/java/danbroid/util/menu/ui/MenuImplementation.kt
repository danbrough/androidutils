package danbroid.util.menu.ui

import android.net.Uri
import android.view.ContextMenu
import android.view.View
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.fragment
import danbroid.util.menu.MenuItem
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.R
import danbroid.util.menu.ui.menulist.MenuListFragment

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
      navController.navigateToMenu(menu.id)
    }
  }

  var menuContextMenuHandler: Fragment.(MenuItem, ContextMenu, View, ContextMenu.ContextMenuInfo?) -> Unit = { menuItem, contextMenu, _, _ ->
    if (menuItem.contextMenuID != 0) {
      requireActivity().menuInflater.inflate(menuItem.contextMenuID, contextMenu)
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

object MenuNavGraph {

  private var idCounter: Int = 1

  val nextID: Int
    get() = idCounter++


  val id = nextID

  object dest {
    val home = nextID
    val menu = nextID
  }

  object action {
    val toMenu = nextID
  }

  object args {
    val menuID = "menuID"
  }
}

fun NavController.createMenuGraph(builder: NavGraphBuilder.() -> Unit = {}) {

  graph = createGraph(MenuNavGraph.id, MenuNavGraph.dest.home) {
    fragment<MenuListFragment>(MenuNavGraph.dest.home) {
      argument(MenuNavGraph.args.menuID) {
        type = NavType.StringType
        defaultValue = "demo://content"
      }
    }


    fragment<MenuListFragment>(MenuNavGraph.dest.menu) {
      argument(MenuNavGraph.args.menuID) {
        type = NavType.StringType
        defaultValue = "demo://content"
      }
    }

    action(MenuNavGraph.action.toMenu) {
      destinationId = MenuNavGraph.dest.menu
    }
  }
}

fun NavController.navigateToMenu(menuID: String) =
    navigate(MenuNavGraph.action.toMenu, bundleOf(MenuNavGraph.args.menuID to menuID))

private val log = org.slf4j.LoggerFactory.getLogger(MenuImplementation::class.java)
