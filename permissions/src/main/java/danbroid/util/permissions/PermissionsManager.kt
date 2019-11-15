package danbroid.util.permissions

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest
import java.util.concurrent.atomic.AtomicInteger

object PermissionsManager {

  internal val REQUEST_CODE = AtomicInteger(1000)

  internal val permissionsChannel: BroadcastChannel<PermissionResult> by lazy {
    BroadcastChannel<PermissionResult>(20)
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
      requestPermission(request).collect {
        callback.invoke(it.results[0])
      }
    }
  }

  internal fun requestPermission(request: PermissionRequest): Flow<PermissionResult> {
    log.debug("requesting permission..")
    EasyPermissions.requestPermissions(request)
    log.debug("waiting on permission channel..")
    return permissionsChannel.asFlow().filter {
      log.trace("filtering flow for request:${request.requestCode} with result: ${it.requestCode}")
      it.requestCode == request.requestCode
    }
  }

  suspend fun withPermissions(
    activity: Activity,
    request: PermissionRequest, callback: suspend (PermissionResult) -> Unit
  ) {
    val requestCode = REQUEST_CODE.incrementAndGet()

    if (EasyPermissions.hasPermissions(activity, *request.perms)) {
      log.trace("has permissions")
      callback.invoke(
        PermissionResult(
          requestCode,
          request.perms,
          request.perms.map { true })
      )
    } else {
      log.trace("requesting permission..")
      requestPermission(request).collect {
        callback.invoke(it)
      }
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

}

private val log = org.slf4j.LoggerFactory.getLogger(PermissionsManager::class.java)

