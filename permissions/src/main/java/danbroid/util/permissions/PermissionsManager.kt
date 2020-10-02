package danbroid.util.permissions

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest
import java.util.concurrent.CancellationException
import java.util.concurrent.atomic.AtomicInteger

/**
 * Manages processing and dispatching of permissions request
 *
 */
@ExperimentalCoroutinesApi
object PermissionsManager {
  private val requestCode = AtomicInteger(2000)

  private val permissionsChannel: BroadcastChannel<PermissionResult> by lazy {
    BroadcastChannel(Channel.BUFFERED)
  }


  suspend fun withPermission(
    context: Context,
    request: PermissionRequest
  ): Boolean = if (EasyPermissions.hasPermissions(context, *request.perms)) {
    log.trace("has permissions")
    true
  } else requestPermission(request).results.first()


  suspend fun withPermission(
    activity: Activity,
    permission: String,
    rationale: String? = null
  ) = withPermission(
    activity,
    PermissionRequest.Builder(activity, requestCode.getAndIncrement(), permission).also {
      if (rationale != null) it.setRationale(rationale)
    }.build()
  )

  private suspend fun requestPermission(
    request: PermissionRequest
  ): PermissionResult {
    log.debug("requesting permission..")
    EasyPermissions.requestPermissions(request)
    log.debug("waiting on permission channel..")
    return permissionsChannel.asFlow().filter { it.requestCode == request.requestCode }.first()
  }


  suspend fun withPermissions(
    activity: Activity,
    request: PermissionRequest
  ): PermissionResult {

    if (EasyPermissions.hasPermissions(activity, *request.perms)) {
      log.trace("has permissions")
      return PermissionResult(
        requestCode.incrementAndGet(),
        request.perms,
        request.perms.map { true })

    } else {
      log.trace("requesting permission..")
      return requestPermission(request)
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

