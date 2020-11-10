package danbroid.util.demo.content

import android.content.Context
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.invalidateMenu
import danbroid.util.menu.menu
import danbroid.util.prefs.Prefs
import danbroid.util.prefs.edit
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.slf4j.LoggerFactory
import java.util.*

class ExamplePrefs(context: Context) : Prefs(context, "example_prefs") {
  var message: String? by Pref(null)
  var count: Int by Pref(1)
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
      log.debug("prefs.count: ${prefs.count}")
      prefs.edit(commit = true) {
        count++
      }
      log.debug("prefs.count now: ${prefs.count}")
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
      invalidateMenu()
      false
    }
  }
}

private val log = LoggerFactory.getLogger("danbroid.util.demo.content")




