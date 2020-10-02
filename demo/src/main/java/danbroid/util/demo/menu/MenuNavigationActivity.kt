package danbroid.util.demo.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import danbroid.util.demo.R
import danbroid.util.menu.ui.MenuImplementation
import danbroid.util.menu.ui.createMenuGraph
import kotlinx.android.synthetic.main.activity_menu_navigation.*

class MenuNavigationActivity : AppCompatActivity() {

  init {
    MenuImplementation.rootContent = {
      rootContent
    }
  }

  protected val navHostFragment: NavHostFragment
    get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu_navigation)
    setSupportActionBar(toolbar)

    navHostFragment.navController.also { controller->
      controller.createMenuGraph()
      setupActionBarWithNavController(controller)
    }
  }

  override fun onSupportNavigateUp() = navHostFragment.navController.navigateUp() || super.onSupportNavigateUp()

}


/*
  <fragment
      android:id="@+id/navigation_menu"
      android:name="danbroid.util.menu.ui.menulist.MenuListFragment"
      tools:layout="@layout/fragment_menu_list">
    <argument
        android:name="menuID"
        android:defaultValue="demo://content" />
  </fragment>

  <fragment
      android:id="@+id/navigation_home"
      android:name="danbroid.util.menu.ui.menulist.MenuListFragment"
      tools:layout="@layout/fragment_menu_list">
    <argument
        android:name="menuID"
        android:defaultValue="demo://content" />
  </fragment>

  <action
      android:id="@+id/action_global_navigation_menu"
      app:destination="@id/navigation_menu" />
 */
private val log = org.slf4j.LoggerFactory.getLogger(MenuNavigationActivity::class.java)

