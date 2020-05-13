package danbroid.util.demo.menu

import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import danbroid.util.menu.MenuItem
import danbroid.util.menu.ui.menulist.AbstractMenuListFragment
import danbroid.util.demo.R
import kotlinx.android.synthetic.main.activity_menu_navigation.*

class MenuNavigationActivity : AppCompatActivity(), AbstractMenuListFragment.MenuItemHandler {
  protected val navController: NavController
    get() = findNavController(R.id.nav_host_fragment)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu_navigation)
    setSupportActionBar(toolbar)
    setupActionBarWithNavController(navController)
  }

  override fun onSupportNavigateUp() = navController.navigateUp() || super.onSupportNavigateUp()

  override fun onClicked(menu: MenuItem) {
    log.info("onClicked() $menu")

    if (menu.isBrowsable) {
      MenuListFragmentDirections.actionGlobalNavigationMenu(menu.id).also {
        navController.navigate(it)
        return
      }
    }

    val uri = Uri.parse(menu.id)
    if (navController.graph.hasDeepLink(Uri.parse(menu.id))) {
      navController.navigate(uri)
      return
    }
  }

  override fun onCreateContextMenu(menuItem: MenuItem, menu: ContextMenu, view: View, menuInfo: ContextMenu.ContextMenuInfo?) {
    TODO("Not yet implemented")
  }

  override fun setToolbarTitle(title: CharSequence) = toolbar.setTitle(title)
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuNavigationActivity::class.java)
