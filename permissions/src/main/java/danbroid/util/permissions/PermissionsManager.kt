package danbroid.util.permissions

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
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
      log.debug("requesting permission..")
      EasyPermissions.requestPermissions(request)
      log.debug("waiting on permission channel..")
      permissionsChannel.asFlow().collect {
        log.warn("received permission result:  $it")
        if (request.requestCode == it.requestCode) {
          callback.invoke(it.results[0])
        }
      }
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
      EasyPermissions.requestPermissions(request)
      log.trace("waiting on permission channel..")
      permissionsChannel.asFlow().collect {
        log.trace("received permission result:  $it")
        if (it.requestCode == requestCode) {
          callback.invoke(it)
        }
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

