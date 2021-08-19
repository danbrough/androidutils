package danbroid.util.menu

import android.content.Context
import androidx.core.os.bundleOf
import androidx.navigation.*
import androidx.navigation.fragment.fragment
import danbroid.util.menu.ui.MenuFragment
import danbroid.util.misc.UniqueIDS

object MenuNavGraph : UniqueIDS {
  val id = nextID()

  object dest {
    val menu = nextID()
    val home = nextID()
  }

  object arg {
    val menu = "menuID"
  }

  object action {
    val to_home = nextID()
    val to_menu = nextID()
  }
}

/**
 * Provides animations for menu transitions
 */
val defaultMenuNavOptions: NavOptionsBuilder.() -> Unit = {
  anim {
    enter = R.anim.menu_enter
    exit = R.anim.menu_exit
    popEnter = R.anim.menu_pop_enter
    popExit = R.anim.menu_pop_exit
  }
}


fun NavController.createMenuNavGraph(context: Context, homeID: Int = MenuNavGraph.dest.home, defaultMenuID: String,
                                     menuNavOptions: (NavOptionsBuilder.() -> Unit) = defaultMenuNavOptions,
                                     builder: (NavGraphBuilder.() -> Unit)? = null): NavGraph {

  return createGraph(MenuNavGraph.id, homeID) {

    fragment<MenuFragment>(MenuNavGraph.dest.menu) {
      argument(MenuNavGraph.arg.menu) {
        type = NavType.StringType
        nullable = false
        defaultValue = defaultMenuID
      }
    }

    fragment<MenuFragment>(MenuNavGraph.dest.home) {
      label = context.getString(R.string.app_name)
      argument(MenuNavGraph.arg.menu) {
        type = NavType.StringType
        nullable = false
        defaultValue = defaultMenuID
      }
      deepLink(defaultMenuID)
    }

    action(MenuNavGraph.action.to_menu) {
      destinationId = MenuNavGraph.dest.menu
      navOptions(menuNavOptions)
    }

    action(MenuNavGraph.action.to_home) {
      destinationId = homeID


      navOptions {
        anim {
          enter = R.anim.menu_pop_enter
          exit = R.anim.menu_pop_exit
        }
      }

    }

    action(MenuNavGraph.action.to_menu) {
      destinationId = MenuNavGraph.dest.menu
      navOptions(menuNavOptions)
    }

    builder?.invoke(this)
  }
}

fun NavController.navigateToMenuID(menuID: String) {
  log.warn("NAVIGATING TO ACTION MENU $menuID")
  navigate(MenuNavGraph.action.to_menu, bundleOf(MenuNavGraph.arg.menu to menuID))
}

fun NavController.navigateToHome() =
    navigate(MenuNavGraph.action.to_home)


private val log = danbroid.logging.getLog(MenuNavGraph::class)
