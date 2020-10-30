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
  onCreate = {
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
  }

  menu {
    title = "Prefs.message not set"
    subtitle = "prefs.message initialized once"
  }
}

private val log = LoggerFactory.getLogger("danbroid.util.demo.content")




