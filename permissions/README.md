
# Permissions Utils

Some utility functions for dealing with android permissions nicely.

## Usage

### Basic 

To do something in an activity that requires a permission:

```kotlin

import androidx.lifecycle.lifecycleScope
import danbroid.util.demo.R
import danbroid.util.permissions.processPermissionResult
import danbroid.util.permissions.withPermission
import kotlinx.android.synthetic.main.activity_permissions.*
import kotlinx.coroutines.launch

class MyActivity : AppCompatActivity() {

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


```

