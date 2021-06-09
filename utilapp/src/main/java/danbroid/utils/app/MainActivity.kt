package danbroid.utils.app

import androidx.navigation.NavController
import danbroid.logging.AndroidLog
import danbroid.logging.LogConfig
import danbroid.logging.getLog
import danbroid.util.menu.MenuActivity
import danbroid.utils.app.content.rootContent

class MainActivity : MenuActivity() {

  companion object {
    init {
      LogConfig.apply {
        DEBUG = BuildConfig.DEBUG
        val tag = "UTILS"
        val log = AndroidLog(tag)
        GET_LOG = { log }
        COLOURED = BuildConfig.DEBUG
        DETAILED = true
      }
    }

    val log = getLog(MainActivity::class)
  }

  private val rootContent by lazy {
    rootContent(this)
  }

  override fun getRootMenu() = rootContent

  override fun createNavGraph(navController: NavController) =
      navController.createUtilsNavGraph(this)
}

