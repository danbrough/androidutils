package danbroid.util.demo

import androidx.navigation.NavController
import danbroid.util.demo.content.rootContent
import danbroid.util.menu.MenuActivity


class MainActivity : MenuActivity() {

  override fun getRootMenu(menuID: String) = rootContent

  override fun createNavGraph(navController: NavController) =
      navController.createDemoNavGraph(this)

}

private val log = org.slf4j.LoggerFactory.getLogger(MainActivity::class.java)
