package danbroid.utils.app.content

import android.content.Context
import com.google.android.material.snackbar.Snackbar
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.MenuItemClickContext
import danbroid.util.menu.menu
import danbroid.util.menu.rootMenu
import danbroid.utils.app.R
import danbroid.utils.app.URI_CONTENT_PREFIX
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.io.InputStreamReader

private val log = danbroid.logging.getLog("danbroid.utils.app.content")

@ExperimentalCoroutinesApi
fun rootContent(context: Context) = context.rootMenu<MenuItemBuilder> {
  id = URI_CONTENT_PREFIX
  titleID = R.string.app_name

  menu {
    title = "Date"
    onClick = {
      runCmd("date")
    }
  }

  menu {
    title = "setprop service.adb.tcp.port 4444"
    onClick = {
      runCmd("setprop service.adb.tcp.port 4444")
    }
  }

}

fun MenuItemClickContext.runCmd(cmd: String) =
    runCatching {
      ProcessBuilder().command(cmd).start().also { process ->
        val result = process.waitFor()
        if (result == 0) {
          InputStreamReader(process.inputStream).use {
            snackBar("Success: ${it.readText()}")
          }
        } else {
          InputStreamReader(process.errorStream).use {
            log.debug("failed ${it.readText()}")
          }
        }
      }
    }.exceptionOrNull()?.also {
      snackBar(it.message ?: "no error")
    }


fun MenuItemClickContext.snackBar(msg: CharSequence) {
  log.debug(msg)
  Snackbar.make(requireActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show()
}