package danbroid.menu2test

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import androidx.navigation.navDeepLink
import danbroid.menu2test.ui.HomeFragment
import danbroid.menu2test.ui.SettingsFragment
import danbroid.util.menu.MenuNavGraph
import danbroid.util.menu.createMenuNavGraph
import danbroid.util.misc.UniqueIDS

const val URI_PREFIX = "demo:/"
const val URI_CONTENT_PREFIX = "$URI_PREFIX/content"

object DemoNavGraph : UniqueIDS {
  val id = nextID()

  object dest {
    val home = nextID()
    val settings = nextID()
  }

  object action {
    val settings = nextID()
  }

  object deep_link {
    val settings = "$URI_PREFIX/settings"
    val home = URI_CONTENT_PREFIX
  }

}

fun NavController.createDemoNavGraph(context: Context, builder: NavGraphBuilder.() -> Unit = {}) =
    createMenuNavGraph(context, homeID = MenuNavGraph.dest.home, defaultMenuID = URI_CONTENT_PREFIX) {

      fragment<HomeFragment>(DemoNavGraph.dest.home) {
        label = "Home"
      }

      fragment<SettingsFragment>(DemoNavGraph.dest.settings) {
        label = "Settings"
        deepLink(DemoNavGraph.deep_link.settings)
      }

      action(DemoNavGraph.action.settings) {
        destinationId = DemoNavGraph.dest.settings
      }

      builder()
    }



