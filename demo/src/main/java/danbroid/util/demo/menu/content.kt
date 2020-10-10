package danbroid.util.demo.menu

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import danbroid.util.demo.R
import danbroid.util.format.humanReadableByteCount
import danbroid.util.menu.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.*

const val URI_CONTENT_ROOT = "demo://content"

val rootContent: MenuItemBuilder by lazy {

  rootMenu {
    id = URI_CONTENT_ROOT
    titleID = R.string.title_menu_activity

    menu {
      title = "First Menu"
      subtitle = "imageURI = \"https://picsum.photos/200\""
      imageURI = "https://picsum.photos/200"
      onClick = {
        Toast.makeText(context, "OnClick handled and ignored", Toast.LENGTH_SHORT).show()
      }
    }

    menu {
      id = "$URI_CONTENT_ROOT/second"
      title = "Second Menu"
      subtitle = "tintRes = R.color.colorAccent"
      onClick = promptToContinue
      tintRes = R.color.colorAccent
      menu {
        title = "Child of Second Menu"
        id = "$URI_CONTENT_ROOT/second/first"

        menu {
          title = "Another Child Folder"
          subtitle = "Has its tint set to R.color.colorSecondaryLight"
          tintRes = R.color.colorSecondaryLight
        }
      }
    }

    menu {
      title = "Live Menu"
      subtitle = "Generates children in the background"
      isBrowsable = true
      liveChildren = liveChildrenProducer
    }

    menu {
      title = "Context Menu"
      subtitle = "Long press for context menu"
      contextMenuID = R.menu.context_menu
    }
  }
}

private val liveChildrenProducer: LiveChildrenProducer = { ctx, id, item ->
  withContext(Dispatchers.Main) {
    Toast.makeText(ctx, "Loading the live menu in one second", Toast.LENGTH_SHORT).show()
  }
  delay(1000)
  listOf(
      MenuItem(item!!.id + "/1", "Sub Menu1", "Created at ${Date()}"),
      MenuItem(item.id + "/2", "Sub Menu2", "menu2")
  )
}

private val promptToContinue: MenuItemClickHandler = { callback ->
  AlertDialog.Builder(context).apply {
    setTitle(android.R.string.dialog_alert_title)
    setMessage("Do you want to continue?")
    setPositiveButton(android.R.string.ok) { dialog, which ->
      callback(true)
    }
    setNegativeButton(android.R.string.cancel) { dialog, which ->
      callback(false)
    }
    show()
  }
}