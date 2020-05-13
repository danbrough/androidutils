package danbroid.util.demo.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import danbroid.util.demo.R
import kotlinx.android.synthetic.main.activity_menu_navigation.*

class MenuNavigationActivity : AppCompatActivity() {
  protected val navController: NavController
    get() = findNavController(R.id.nav_host_fragment)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu_navigation)
    setSupportActionBar(toolbar)
    setupActionBarWithNavController(navController)
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MenuNavigationActivity::class.java)
