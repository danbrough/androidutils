package danbroid.util.demo.permissions

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import danbroid.util.demo.R
import danbroid.util.permissions.processPermissionResult
import kotlinx.android.synthetic.main.activity_permissions.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.EasyPermissions
import java.io.File
import java.util.concurrent.atomic.AtomicInteger


class PermissionsActivity : AppCompatActivity(), EasyPermissions.RationaleCallbacks {

  override fun onRationaleDenied(requestCode: Int) {
    AlertDialog.Builder(this).setMessage("Opportunity to retry.. hit OK to retry ..")
      .setTitle("Rationale was denied!")
      .setPositiveButton(android.R.string.ok) { dialog, which ->

      }.show()
  }

  override fun onRationaleAccepted(requestCode: Int) {
    Toast.makeText(this, "Rationale accepted", Toast.LENGTH_SHORT).show()
  }


  val channel = BroadcastChannel<String>(Channel.BUFFERED)
  val flowID = AtomicInteger(0)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_permissions)

    /**
     * Simple request for #Manifest.permission.READ_EXTERNAL_STORAGE access
     */
    button_browse.setOnClickListener {
      showDir(File("/sdcard/"), false)
    }


    button_permission_settings.setOnClickListener {
      val id = flowID.incrementAndGet()

      lifecycleScope.launch(Dispatchers.Default) {
        log.trace("collecting for $id")
        val flow = channel.asFlow()
          .collect {
            log.trace("$id collected $it")
          }

      }.invokeOnCompletion {
        log.warn("FLOW $id finished")
      }

    }

    if (savedInstanceState == null)
      showDir(File("/sdcard/"), false)


  }


  private fun setContent(fragment: Fragment, addToBackStack: Boolean = true) =
    supportFragmentManager.commit {
      replace(R.id.content_fragment, fragment)
      if (addToBackStack) addToBackStack(null)
    }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    processPermissionResult(requestCode, permissions, grantResults)
  }

  fun showDir(directory: File, addToBackStack: Boolean = true) {
    log.warn("showDir() $directory")
    title = directory.path
    setContent(FileBrowserFragment().also {
      it.path = directory.path
    }, addToBackStack)
  }


}


private val log = org.slf4j.LoggerFactory.getLogger(PermissionsActivity::class.java)

