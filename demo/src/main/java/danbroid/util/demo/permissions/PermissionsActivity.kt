package danbroid.util.demo.permissions

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import danbroid.util.demo.R
import danbroid.util.permissions.processPermissionResult
import danbroid.util.permissions.withPermission
import kotlinx.android.synthetic.main.activity_permissions.*
import kotlinx.coroutines.launch
import java.io.File


class PermissionsActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_permissions)

    /**
     * Simple request for #Manifest.permission.READ_EXTERNAL_STORAGE access
     */
    button_browse.setOnClickListener {
      lifecycleScope.launch {
        withPermission(Manifest.permission.READ_EXTERNAL_STORAGE) {
          Toast.makeText(
            this@PermissionsActivity,
            if (it) "Permission Granted" else "Permission Denied",
            Toast.LENGTH_SHORT
          ).show()
        }
      }
    }

    button_permission_settings.setOnClickListener {
      showPermissionSettings()
    }

    if (savedInstanceState == null)
      setContent(FileBrowserFragment(), false)
  }

  fun showPermissionSettings() {
    startActivity(
      Intent(
        android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
      )
    )
  }

  private fun setContent(fragment: Fragment, addToBackStack: Boolean = true) =
    supportFragmentManager.commit {
      replace(R.id.content_fragment, fragment)
      if (addToBackStack) addToBackStack(null)
    }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    //  super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    processPermissionResult(requestCode, permissions, grantResults)
  }

  fun showDir(directory: File) {
    log.warn("showDir() $directory")
    setContent(FileBrowserFragment().also {
      it.path = directory.path
    })
  }


}


private val log = org.slf4j.LoggerFactory.getLogger(PermissionsActivity::class.java)

