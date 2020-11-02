package danbroid.util.permissions

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import pub.devrel.easypermissions.PermissionRequest


@ExperimentalCoroutinesApi
suspend fun AppCompatActivity.withPermission(
    permission: String,
    rationale: String? = null
) = PermissionsManager.withPermission(this, permission, rationale)

@ExperimentalCoroutinesApi
suspend fun AppCompatActivity.withPermission(
    permission: String,
    rationale: String? = null,
    callback: suspend (granted: Boolean) -> Unit
) = callback.invoke(PermissionsManager.withPermission(this, permission, rationale))


@ExperimentalCoroutinesApi
suspend fun Fragment.withPermission(
    permission: String,
    rationale: String? = null
) = PermissionsManager.withPermission(activity!!, permission, rationale)

@ExperimentalCoroutinesApi
suspend fun Fragment.withPermission(
    permission: String,
    rationale: String? = null,
    callback: suspend (granted: Boolean) -> Unit
) = callback.invoke(PermissionsManager.withPermission(activity!!, permission, rationale))

/**
 * Displays the settings for this application so that
 * the user can modify the permissions
 */
fun Activity.showAppPermissionsSettings() = startActivity(
    Intent(
        android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    )
)

@ExperimentalCoroutinesApi
suspend fun Fragment.withPermissions(request: PermissionRequest) =
    PermissionsManager.withPermissions(activity!!, request)


@ExperimentalCoroutinesApi
suspend fun Activity.withPermissions(request: PermissionRequest) =
    PermissionsManager.withPermissions(this, request)


fun AppCompatActivity.processPermissionResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) = PermissionsManager.processPermissionResult(this, requestCode, permissions, grantResults)


//private val log = org.slf4j.LoggerFactory.getLogger(PermissionResult::class.java.`package`!!.name)

