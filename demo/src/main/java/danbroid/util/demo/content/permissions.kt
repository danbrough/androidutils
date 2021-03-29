package danbroid.util.demo.content

import android.Manifest
import android.widget.Toast
import danbroid.logging.getLog
import danbroid.util.menu.MenuItemBuilder
import danbroid.util.menu.menu
import danbroid.util.permissions.showAppPermissionsSettings
import danbroid.util.permissions.withPermission
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.withContext
import java.io.File

@ExperimentalCoroutinesApi
internal fun MenuItemBuilder.permissionExamples() = menu {
  title = "Permissions Example"

  menu {
    title = "Browse /sdcard/"



    onClick = {
      if (fragment.withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
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


private val log = getLog("danbroid.util.demo.content")




