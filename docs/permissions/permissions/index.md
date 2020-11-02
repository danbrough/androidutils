//[permissions](index.md)



# permissions  
 [common] 

##  Permissions library   


Some utility functions for dealing with android permissions using kotlin extensions



Published via jitpack's maven repository:  com.github.danbrough.androidutils:permissions:master-SNAPSHOT



##  Usage  


###  Basic   


To do something in an activity that requires a permission:

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
        withPermission(Manifest.permission.READ_EXTERNAL_STORAGE) { granted ->  
          Toast.makeText(  
            this@PermissionsActivity,  
            if (granted) "Permission Granted" else "Permission Denied",  
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

see the [demo app](https://github.com/danbrough/androidutils/tree/master/demo) for more information.

   
 [androidJvm] 

##  Permissions library   


Some utility functions for dealing with android permissions using kotlin extensions



Published via jitpack's maven repository:  com.github.danbrough.androidutils:permissions:master-SNAPSHOT



##  Usage  


###  Basic   


To do something in an activity that requires a permission:

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
        withPermission(Manifest.permission.READ_EXTERNAL_STORAGE) { granted ->  
          Toast.makeText(  
            this@PermissionsActivity,  
            if (granted) "Permission Granted" else "Permission Denied",  
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

see the [demo app](https://github.com/danbrough/androidutils/tree/master/demo) for more information.



##  Permissions library   


Some utility functions for dealing with android permissions using kotlin extensions



Published via jitpack's maven repository:  com.github.danbrough.androidutils:permissions:master-SNAPSHOT



##  Usage  


###  Basic   


To do something in an activity that requires a permission:

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
        withPermission(Manifest.permission.READ_EXTERNAL_STORAGE) { granted ->  
          Toast.makeText(  
            this@PermissionsActivity,  
            if (granted) "Permission Granted" else "Permission Denied",  
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

see the [demo app](https://github.com/danbrough/androidutils/tree/master/demo) for more information.



##  Permissions library   


Some utility functions for dealing with android permissions using kotlin extensions



Published via jitpack's maven repository:  com.github.danbrough.androidutils:permissions:master-SNAPSHOT



##  Usage  


###  Basic   


To do something in an activity that requires a permission:

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
        withPermission(Manifest.permission.READ_EXTERNAL_STORAGE) { granted ->  
          Toast.makeText(  
            this@PermissionsActivity,  
            if (granted) "Permission Granted" else "Permission Denied",  
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

see the [demo app](https://github.com/danbrough/androidutils/tree/master/demo) for more information.

   


## Packages  
  
|  Name|  Summary| 
|---|---|
| <a name="danbroid.util.permissions////PointingToDeclaration/"></a>[danbroid.util.permissions](danbroid.util.permissions/index.md) | 

