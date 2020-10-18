package danbroid.menu2test

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import danbroid.menu2test.content.rootContent
import danbroid.util.menu.MenuActivity


class MainActivity : MenuActivity() {

  override fun getRootMenu(menuID: String) = rootContent

  override fun createNavGraph(navController: NavController) =
      navController.createDemoNavGraph(this)

}

private val log = org.slf4j.LoggerFactory.getLogger(MainActivity::class.java)
