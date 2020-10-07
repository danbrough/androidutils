package danbroid.util.menu.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import danbroid.util.menu.ui.menulist.MenuListFragment
import java.util.concurrent.atomic.AtomicInteger

/**
 * Provides a [#nextID] method to return an incremental unique id
 */
interface UniqueIDS {
  companion object {
    private var _id = AtomicInteger(0)
  }

  fun nextID() = _id.incrementAndGet()
}

object MenuNavGraph : UniqueIDS {

  val id = nextID()

  object dest {
    val home = nextID()
    val menu = nextID()
  }

  object action {
    val toMenu = nextID()
  }

  object args {
    val menuID = "menuID"
  }
}

fun NavController.createMenuGraph(
  deeplinkPrefix: String = "demo://content",
  builder: NavGraphBuilder.() -> Unit = {}
) {

  graph = createGraph(MenuNavGraph.id, MenuNavGraph.dest.home) {
    fragment<MenuListFragment>(MenuNavGraph.dest.home) {
      argument(MenuNavGraph.args.menuID) {
        type = NavType.StringType
        defaultValue = deeplinkPrefix
      }
    }


    fragment<MenuListFragment>(MenuNavGraph.dest.menu) {
      argument(MenuNavGraph.args.menuID) {
        type = NavType.StringType
        defaultValue = deeplinkPrefix
      }
    }

    action(MenuNavGraph.action.toMenu) {
      destinationId = MenuNavGraph.dest.menu
    }

    builder()
  }
}

fun NavController.navigateToMenu(menuID: String) =
  navigate(MenuNavGraph.action.toMenu, bundleOf(MenuNavGraph.args.menuID to menuID))

