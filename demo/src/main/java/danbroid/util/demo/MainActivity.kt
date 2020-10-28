package danbroid.util.demo

import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import danbroid.util.demo.content.rootContent
import danbroid.util.menu.MenuActivity
import danbroid.util.permissions.PermissionsManager.processPermissionResult
import kotlinx.coroutines.ExperimentalCoroutinesApi


class MainActivity : MenuActivity() {

  override fun getRootMenu(menuID: String) = rootContent

  override fun createNavGraph(navController: NavController) =
      navController.createDemoNavGraph(this)

  @ExperimentalCoroutinesApi
  override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    processPermissionResult(this, requestCode, permissions, grantResults)
  }

}

private val log = org.slf4j.LoggerFactory.getLogger(MainActivity::class.java)
