package danbroid.util.demo

import android.os.Bundle
import androidx.navigation.NavController
import danbroid.logging.AndroidLog
import danbroid.logging.LogConfig
import danbroid.logging.getLog
import danbroid.util.demo.content.rootContent
import danbroid.util.menu.MenuActivity
import danbroid.util.permissions.PermissionsManager.processPermissionResult
import kotlinx.coroutines.ExperimentalCoroutinesApi


class MainActivity : MenuActivity() {

  companion object {
    init {
      LogConfig.apply {
        val tag = "DEMO"
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
      navController.createDemoNavGraph(this)


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    log.info("onCreate()")
  }

  @ExperimentalCoroutinesApi
  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    processPermissionResult(this, requestCode, permissions, grantResults)
  }

}


