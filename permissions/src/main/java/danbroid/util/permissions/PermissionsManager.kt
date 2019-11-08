package danbroid.util.permissions

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest
import java.util.concurrent.CancellationException
import java.util.concurrent.atomic.AtomicInteger

class PermissionsManager(val activity: AppCompatActivity) {

  var fragment: Fragment? = null

  val context: Context
    get() = fragment?.context ?: activity


  constructor(fragment: Fragment) : this(fragment.activity!! as AppCompatActivity) {
    this.fragment = fragment
  }

  data class PermissionResult(
    val requestCode: Int,
    val permissions: Array<String>,
    val results: List<Boolean>
  ) {
    fun isGranted(permission: String) =
      permissions.indexOf(permission).let {
        if (it > -1) results[it] else false
      }
  }

  private val permissionsChannel: BroadcastChannel<PermissionResult> by lazy {
    BroadcastChannel<PermissionResult>(20)
  }

  suspend fun withPermission(
    activity: AppCompatActivity,
    permission: String,
    callback: suspend (Boolean) -> Unit
  ) = withPermission(
    PermissionRequest.Builder(
      activity,
      REQUEST_CODE.getAndIncrement(),
      permission
    ).build(),
    callback
  )

  suspend fun withPermission(
    fragment: Fragment,
    permission: String,
    callback: suspend (Boolean) -> Unit
  ) = withPermission(
    PermissionRequest.Builder(
      fragment,
      REQUEST_CODE.getAndIncrement(),
      permission
    ).build(),
    callback
  )

  suspend fun withPermission(
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

  companion object {
    private val REQUEST_CODE = AtomicInteger(1243)
  }


  suspend fun withPermissions(
    request: PermissionRequest,
    callback: suspend (PermissionResult) -> Unit
  ) {
    val requestCode = REQUEST_CODE.incrementAndGet()

    if (EasyPermissions.hasPermissions(context, *request.perms)) {
      log.trace("has permissions")
      callback.invoke(PermissionResult(requestCode, request.perms, request.perms.map { true }))
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


  fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<String>,
    grantResults: IntArray
  ) {
    log.info("onRequestPermissionsResult()")

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

