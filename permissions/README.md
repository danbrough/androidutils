
# Permissions Utils

Some utility functions for dealing with android permissions nicely.

## Usage

### Basic 

To do something in an activity that requires a permission:

```kotlin

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
}


```

