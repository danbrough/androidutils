package danbroid.util.permissions

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest
import java.util.concurrent.CancellationException

/**
 * Manages processing and dispatching of permissions request
 *
 */
object PermissionsManager {
  const val REQUEST_CODE = 1234

  private val permissionsChannel: BroadcastChannel<PermissionResult> by lazy {
    BroadcastChannel<PermissionResult>(Channel.BUFFERED)
  }


  suspend fun withPermission(
    context: Context,
    request: PermissionRequest,
    callback: suspend (Boolean) -> Unit
  ) {
    if (EasyPermissions.hasPermissions(context, *request.perms)) {
      log.trace("has permissions")
      callback.invoke(true)
    } else {
      requestPermission(request) {
        if (it.permissions[0] == request.perms[0]) {
          callback.invoke(it.results[0])
          false
        } else true
      }

    }
  }

  private suspend fun requestPermission(
    request: PermissionRequest,
    callback: suspend (PermissionResult) -> Boolean
  ) {
    log.debug("requesting permission..")
    EasyPermissions.requestPermissions(request)
    log.debug("waiting on permission channel..")
    val subscription = permissionsChannel.openSubscription()
    do {
      val result = subscription.receive()
    } while (callback.invoke(result))

    log.warn("cancelling subscription")
    subscription.cancel()
  }

  suspend fun withPermissions(
    activity: Activity,
    request: PermissionRequest, callback: suspend (PermissionResult) -> Boolean
  ) {

    if (EasyPermissions.hasPermissions(activity, *request.perms)) {
      log.trace("has permissions")
      callback.invoke(
        PermissionResult(
          REQUEST_CODE,
          request.perms,
          request.perms.map { true })
      )
    } else {
      log.trace("requesting permission..")
      requestPermission(request, callback)
    }
  }

  fun processPermissionResult(
    activity: AppCompatActivity,
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    log.info("processPermissionResult()")

    activity.lifecycleScope.launch(Dispatchers.Main) {
      permissionsChannel.send(
        PermissionResult(
          requestCode,
          permissions,
          grantResults.map { it == PackageManager.PERMISSION_GRANTED })
      )
    }
  }

  fun close() {
    permissionsChannel.cancel(CancellationException("PermissionsManager was closed"))
  }

}

private val log = org.slf4j.LoggerFactory.getLogger(PermissionsManager::class.java)

