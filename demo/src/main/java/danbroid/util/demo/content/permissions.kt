package danbroid.util.demo.content

import android.Manifest
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import danbroid.util.menu.MenuItem
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.menu
import danbroid.util.permissions.showAppPermissionsSettings
import danbroid.util.permissions.withPermission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*
import kotlin.coroutines.suspendCoroutine

@ExperimentalCoroutinesApi
internal fun MenuItemBuilder.permissionExamples() = menu {
  title = "Permissions Example"

  menu {
    title = "Browse /sdcard/"



    onClick = {
      if (withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
        fileMenu(File("/sdcard/"))
        true
      } else {
        Toast.makeText(requireContext(), "Do not have permission", Toast.LENGTH_SHORT).show()
        false
      }
    }
  }

  menu {
    title = "App Permissions"
    subtitle = "Can reconfigure permissions here"
    onClick = {
      requireActivity().showAppPermissionsSettings()
      false
    }
  }
}

private fun MenuItemBuilder.fileMenu(file: File): MenuItemBuilder = menu {
  id = file.canonicalPath
  title = file.name
  subtitle = file.absolutePath

  onClick = {
    withContext(Dispatchers.IO) {
      if (file.isDirectory) {
        file.listFiles()?.forEach { child ->
          log.error("adding child: ${child.path}")
          fileMenu(child)
        }
      }
      isBrowsable = !children.isNullOrEmpty()
    }
    log.error("returning true ")
    true
  }
}


private val log = LoggerFactory.getLogger("danbroid.util.demo.content")




