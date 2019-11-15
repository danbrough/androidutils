package danbroid.util.permissions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import danbroid.util.permissions.PermissionsManager.REQUEST_CODE
import pub.devrel.easypermissions.PermissionRequest


suspend fun AppCompatActivity.withPermission(
  permission: String,
  rationale: String? = null,
  callback: suspend (Boolean) -> Unit
) =
  PermissionsManager.withPermission(
    this@withPermission,
    PermissionRequest.Builder(
      this@withPermission,
      REQUEST_CODE,
      permission
    ).also {
      if (rationale != null) it.setRationale(rationale)
    }.build(),
    callback
  )


suspend fun Fragment.withPermission(
  permission: String,
  rationale: String? = null,
  callback: suspend (Boolean) -> Unit
) = PermissionsManager.withPermission(
  context!!,
  PermissionRequest.Builder(
    activity!!,
    REQUEST_CODE,
    permission
  ).also {
    if (rationale != null) it.setRationale(rationale)
  }.build(),
  callback
)

/**
 * Displays the settings for this application so that
 * the user can modify the permissions
 */
fun AppCompatActivity.showAppPermissionsSettings() = startActivity(
  Intent(
    android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
    Uri.fromParts("package", packageName, null)
  )
)

suspend fun Fragment.withPermissions(
  request: PermissionRequest, callback: suspend (PermissionResult) -> Boolean
) = PermissionsManager.withPermissions(activity!!, request, callback)


suspend fun Activity.withPermissions(
  request: PermissionRequest, callback: suspend (PermissionResult) -> Boolean
) = PermissionsManager.withPermissions(this, request, callback)


fun AppCompatActivity.processPermissionResult(
  requestCode: Int,
  permissions: Array<out String>,
  grantResults: IntArray
) = PermissionsManager.processPermissionResult(this, requestCode, permissions, grantResults)


private val log = org.slf4j.LoggerFactory.getLogger(PermissionResult::class.java.`package`!!.name)

