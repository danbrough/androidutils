package danbroid.util.menu.navigation

import androidx.core.os.bundleOf
import androidx.navigation.*
import androidx.navigation.fragment.fragment
import danbroid.util.menu.R
import danbroid.util.menu.ui.menulist.MenuListFragment
import danbroid.util.misc.UniqueIDS
import java.util.concurrent.atomic.AtomicInteger


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

val defaultMenuNavOptions: NavOptionsBuilder.() -> Unit = {
  anim {
    enter = R.anim.menu_enter
    exit = R.anim.menu_exit
    popEnter = R.anim.menu_pop_enter
    popExit = R.anim.menu_pop_exit
  }
}


fun NavController.createMenuGraph(
    deeplinkPrefix: String = "demo://content",
    menuNavOptions: (NavOptionsBuilder.() -> Unit)? = null,
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
      navOptions(menuNavOptions ?: defaultMenuNavOptions)
    }

    builder()
  }
}

fun NavController.navigateToMenu(menuID: String) =
    navigate(MenuNavGraph.action.toMenu, bundleOf(MenuNavGraph.args.menuID to menuID))

