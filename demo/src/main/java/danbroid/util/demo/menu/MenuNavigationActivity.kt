package danbroid.util.demo.menu

import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import danbroid.util.demo.R
import danbroid.util.menu.MenuItem
import danbroid.util.menu.ui.MenuImplementation
import danbroid.util.menu.ui.menulist.MenuListFragment
import danbroid.util.menu.ui.menulist.MenuListFragmentDirections
import kotlinx.android.synthetic.main.activity_menu_navigation.*

class MenuNavigationActivity : AppCompatActivity() {

  init {
    MenuImplementation.rootContent = {
      rootContent
    }
  }

  protected val navController: NavController
    get() = findNavController(R.id.nav_host_fragment)

  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu_navigation)
    setSupportActionBar(toolbar)
    setupActionBarWithNavController(navController)
  }

  override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()

}

private val log = org.slf4j.LoggerFactory.getLogger(MenuNavigationActivity::class.java)
