package danbroid.util.demo.menu

import androidx.navigation.NavController
import androidx.navigation.fragment.fragment
import danbroid.util.menu.navigation.createMenuGraph
import danbroid.util.misc.UniqueIDS

object DemoNavGraph : UniqueIDS {
  const val URI_PREFIX = "demo:/"
  const val URI_CONTENT_PREFIX = "$URI_PREFIX/content"

  object dest {
    val settings_id = nextID()
  }

  object action {
    val to_settings = nextID()
  }
}

fun NavController.createDemoNavGraph() {
  createMenuGraph(deeplinkPrefix = DemoNavGraph.URI_CONTENT_PREFIX) {

    fragment<SettingsFragment>(DemoNavGraph.dest.settings_id)

    action(DemoNavGraph.action.to_settings) {
      destinationId = DemoNavGraph.dest.settings_id
    }
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(DemoNavGraph::class.java)
