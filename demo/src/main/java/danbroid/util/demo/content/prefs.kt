package danbroid.util.demo.content

import android.content.Context
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.menu
import danbroid.util.menu.model.menuViewModel
import danbroid.util.prefs.Prefs
import danbroid.util.prefs.edit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.slf4j.LoggerFactory
import java.util.*

class ExamplePrefs(context: Context) : Prefs(context) {
  var message: String? by Pref(null)
  var count: Int by Pref(1)
  override fun createPrefs() = context.getSharedPreferences("example_prefs", Context.MODE_PRIVATE)
}

private fun Context.demoPrefs(): ExamplePrefs = ExamplePrefs(this)


@ExperimentalCoroutinesApi
internal fun MenuItemBuilder.prefsExamples() = menu {
  title = "Prefs Example"
  subtitle = "SharedPreference demo"

  isBrowsable = true

  val prefs = requireContext().demoPrefs()

  menu {
    title = "Prefs.Count: ${prefs.count}"
    subtitle = "Click to increment"
    onClick = {
      requireContext().demoPrefs().edit {
        count++
      }
      menuViewModel().invalidate(this)
      false
    }
  }

  menu {
    title = prefs.message ?: let {
      val msg = "prefs.message: ${Date()}"
      prefs.edit {
        this.message = msg
      }
      msg
    }
    subtitle = "prefs.message initialized once"
  }

  menu {
    title = "Remove prefs.message"
    subtitle = "reset prefs.message to null"
    onClick = {
      requireContext().demoPrefs().edit {
        message = null
      }
      menuViewModel().invalidate(this)
      false
    }
  }
}

private val log = LoggerFactory.getLogger("danbroid.util.demo.content")




