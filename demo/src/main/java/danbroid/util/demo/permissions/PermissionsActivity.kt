package danbroid.util.demo.permissions

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import danbroid.util.demo.R
import danbroid.util.permissions.processPermissionResult
import danbroid.util.permissions.withPermission
import kotlinx.android.synthetic.main.activity_permissions.*
import kotlinx.coroutines.launch

class PermissionsActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_permissions)

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
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    //  super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    processPermissionResult(requestCode, permissions, grantResults)
  }


}

private val log = org.slf4j.LoggerFactory.getLogger(PermissionsActivity::class.java)

