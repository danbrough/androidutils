package danbroid.util.demo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import danbroid.util.demo.permissions.PermissionsActivity
import danbroid.util.prefs.HasPrefs
import danbroid.util.prefs.IntPref
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Displays a list of activities to launch
 * @see [PermissionsActivity]
 */
class MainActivity : AppCompatActivity(), HasPrefs {

  override val prefs: SharedPreferences
    get() = getSharedPreferences("prefs", Context.MODE_PRIVATE)


  enum class PreferenceKeys {
    COUNTER
  }

  private var prefsCounter by IntPref(PreferenceKeys.COUNTER, 0)

  class Demo(val title: String, val activityClass: Class<out Activity>) {
    override fun toString() = title
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    log.info("onCreate()")
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    Toast.makeText(this, "prefsCounter is: $prefsCounter", Toast.LENGTH_SHORT).show()
    prefsCounter++

    val demos = listOf(
      Demo("Permissions", PermissionsActivity::class.java)
    )

    val adapter = object : ArrayAdapter<Demo>(this, android.R.layout.simple_list_item_1, demos) {
      override fun hasStableIds() = true
    }

    demo_list.adapter = adapter

    demo_list.setOnItemClickListener { parent, view, position, id ->
      val demo = adapter.getItem(position)!!
      log.info("opening demo $demo")
      startActivity(Intent(this, demo.activityClass))
    }

  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MainActivity::class.java)

