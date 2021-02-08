package danbroid.util.demo.content

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import danbroid.util.demo.DemoNavGraph
import danbroid.util.demo.R
import danbroid.util.demo.URI_CONTENT_PREFIX
import danbroid.util.menu.*
import danbroid.util.menu.Icons.iconicsIcon
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import java.util.*
import kotlin.coroutines.suspendCoroutine

private val log = LoggerFactory.getLogger("danbroid.util.demo.content")

@ExperimentalCoroutinesApi
fun rootContent(context: Context) = context.rootMenu<MenuItemBuilder> {
  id = URI_CONTENT_PREFIX
  titleID = R.string.app_name

  menu {
    title = "Handle Long click"
    onClick = {
    }
    onLongClick = {
      Toast.makeText(context, "Long click handled", Toast.LENGTH_SHORT).show()
    }
  }

  menu {
    title = "Dynamic Children"
    subtitle = "Generates children when clicked"
    val random = Random()
    var viewCount = 1
    isBrowsable = true
    onClick = {
      children?.clear()
      title = "View count: ${viewCount++}"
      (0 until random.nextInt(10) + 1).forEach {
        menu {
          title = "Child $it"
          subtitle = "${Date()}"
        }
      }

    }
  }

  menu {
    title = "Context Menu Item"
    subtitle = "Long press for context menu"
    icon = iconicsIcon(GoogleMaterial.Icon.gmd_restaurant_menu)

    contextMenu = { fragment ->
      setHeaderTitle("Items")
      add("Item 1").setOnMenuItemClickListener {
        Toast.makeText(fragment.requireContext(), "Clicked: $it", Toast.LENGTH_SHORT).show()
        true
      }
      add("Item 2").setOnMenuItemClickListener {
        Toast.makeText(fragment.requireContext(), "Clicked: $it", Toast.LENGTH_SHORT).show()
        true
      }
    }
  }

  menu {
    title = "Menu 1"
    subtitle = context.getString(R.string.app_name)

    onClick = {
      Toast.makeText(context, "Opening menu ${this@menu.id} in 1 second", Toast.LENGTH_SHORT).show()
      delay(1000)
      true
    }

    menu {
      title = "Submenu 1"
      subtitle = "tintRes = R.color.colorAccent"
      tintRes = R.color.colorAccent
    }

    menu {
      title = "Submenu 2"
      subtitle = "second sub menu"


      menu {
        title = "Home Action"
        subtitle = "calls navController?.navigateToHome()"
        icon = iconicsIcon(GoogleMaterial.Icon.gmd_home)

        onClick = {
          findNavController().navigateToHome()
        }
      }


      menu {
        title = "Change Test"
        subtitle = "Updates the model using onClick"
        var counter = 1

        onClick = {
          subtitle = "Counter: ${counter++}"
          invalidateMenu()
        }
      }


      menu {
        id = DemoNavGraph.deep_link.home
        title = "Deeplink to Home"
        subtitle = "uses deeplink ${DemoNavGraph.deep_link.home} as id"
        icon = Icons.iconicsIcon(GoogleMaterial.Icon.gmd_home)
      }
    }

  }

  menu {
    title = "Menu 2"
    subtitle = """imageURI = "https://picsum.photos/128"
roundedCorners = true"""
    imageURI = "https://picsum.photos/128"
    roundedCorners = true
    menu {
      title = "Inline Children Example"
      inlineChildren = true



      menu {
        title = "Inline Child 1"
        onCreate = { item ->
          item.title = "The date is ${Date()}"
        }
      }
      menu {
        title = "Inline Child 2"
      }
    }
  }

  iconExamples()

  permissionExamples()

  prefsExamples()

  menu {
    id = DemoNavGraph.deep_link.settings
    title = "Settings"
    subtitle = "deeplink: $id"
    imageID = R.drawable.ic_settings
    onClick = promptToContinue
  }


}

private val promptToContinue: MenuItemClickHandler = {
  log.info("promptToCOntinue")
  suspendCoroutine<Boolean> { cont ->
    AlertDialog.Builder(requireContext()).apply {
      setTitle(android.R.string.dialog_alert_title)
      setMessage("Do you want to continue?")
      setPositiveButton(android.R.string.ok) { _, _ ->
        cont.resumeWith(Result.success(true))
      }
      setNegativeButton(android.R.string.cancel) { _, _ ->
        cont.resumeWith(Result.success(false))
      }
      show()
    }
  }.also {
    if (it) proceed()
  }
}

