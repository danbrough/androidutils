package danbroid.util.permissions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import danbroid.util.permissions.PermissionsManager.REQUEST_CODE
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.PermissionRequest


suspend fun AppCompatActivity.withPermission(
  permission: String,
  callback: suspend (Boolean) -> Unit
) =
  PermissionsManager.withPermission(
    this@withPermission,
    PermissionRequest.Builder(
      this@withPermission,
      REQUEST_CODE.getAndIncrement(),
      permission
    ).build(),
    callback
  )


suspend fun Fragment.withPermission(
  permission: String,
  callback: suspend (Boolean) -> Unit
) = PermissionsManager.withPermission(
  context!!,
  PermissionRequest.Builder(
    activity!!,
    REQUEST_CODE.getAndIncrement(),
    permission
  ).build(),
  callback
)


suspend fun Fragment.withPermissions(
  request: PermissionRequest, callback: suspend (PermissionResult) -> Unit
) = activity!!.withPermissions(request, callback)


suspend fun Activity.withPermissions(
  request: PermissionRequest, callback: suspend (PermissionResult) -> Unit
) = PermissionsManager.withPermissions(this, request, callback)


fun AppCompatActivity.processPermissionResult(
  requestCode: Int,
  permissions: Array<out String>,
  grantResults: IntArray
) = PermissionsManager.processPermissionResult(this, requestCode, permissions, grantResults)


private val log = org.slf4j.LoggerFactory.getLogger(PermissionResult::class.java.`package`!!.name)

