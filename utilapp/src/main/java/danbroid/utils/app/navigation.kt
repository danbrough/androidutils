package danbroid.utils.app

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import danbroid.util.menu.createMenuNavGraph
import danbroid.util.misc.UniqueIDS

const val URI_PREFIX = "utils:/"
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

fun NavController.createUtilsNavGraph(context: Context, builder: NavGraphBuilder.() -> Unit = {}) =
    createMenuNavGraph(context, defaultMenuID = URI_CONTENT_PREFIX) {

/*
      fragment<HomeFragment>(DemoNavGraph.dest.home) {
        label = "Home"
      }

      fragment<SettingsFragment>(DemoNavGraph.dest.settings) {
        label = DemoNavGraph.deep_link.settings
        deepLink(DemoNavGraph.deep_link.settings)
      }
*/

      /*    action(DemoNavGraph.action.settings) {
            destinationId = DemoNavGraph.dest.settings
          }*/

      builder()
    }



