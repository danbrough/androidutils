package danbroid.util.demo.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import danbroid.util.demo.R
import danbroid.util.menu.navigation.createMenuGraph
import danbroid.util.menu.ui.MenuImplementation

import kotlinx.android.synthetic.main.activity_menu_navigation.*

class MenuNavigationActivity : AppCompatActivity() {

  init {
    MenuImplementation.rootContent = {
      rootContent
    }
  }

  companion object{
    private val log = org.slf4j.LoggerFactory.getLogger(MenuNavigationActivity::class.java)
  }

  protected val navHostFragment: NavHostFragment
    get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu_navigation)
    setSupportActionBar(toolbar)

    navHostFragment.navController.also { controller ->
      controller.createDemoNavGraph()
      setupActionBarWithNavController(controller)
    }
  }

  override fun onSupportNavigateUp() = navHostFragment.navController.navigateUp() || super.onSupportNavigateUp()

}



