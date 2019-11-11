package danbroid.util.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import danbroid.util.demo.permissions.PermissionsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  class Demo(val title: String, val activityClass: Class<out Activity>) {
    override fun toString() = title
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val demos = listOf(
      Demo("Permissions", PermissionsActivity::class.java)
    )


    val adapter = object : ArrayAdapter<Demo>(this, android.R.layout.simple_list_item_1, demos) {

      override fun hasStableIds() = true
    }


    list_view.adapter = adapter
    list_view.setOnItemClickListener { parent, view, position, id ->
      val demo = adapter.getItem(position)!!
      log.debug("opening demo $demo")
      startActivity(Intent(this, demo.activityClass))
    }

  }
}

private val log = org.slf4j.LoggerFactory.getLogger(MainActivity::class.java)

