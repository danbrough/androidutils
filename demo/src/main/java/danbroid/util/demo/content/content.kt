package danbroid.util.demo.content

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.sizeDp
import danbroid.util.demo.DemoNavGraph
import danbroid.util.demo.R
import danbroid.util.demo.URI_CONTENT_PREFIX
import danbroid.util.menu.*
import danbroid.util.menu.model.menuViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import java.util.*
import kotlin.coroutines.suspendCoroutine

private val log = LoggerFactory.getLogger("danbroid.util.demo.menu2test.content")

@ExperimentalCoroutinesApi
val rootContent = rootMenu<MenuItemBuilder> {
  id = URI_CONTENT_PREFIX
  titleID = R.string.app_name

  menu {
    title = "Dynamic Children"
    val random = Random()
    onClick = {
      children?.clear()
      (0 until random.nextInt(10) + 1).forEach {
        menu {
          title = "Child $it"
          subtitle = "${Date()}"
        }
      }
      true
    }
  }

  menu {
    title = "Menu 1"
    subtitle = "subtitle for menu1"

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
        icon = Icons.iconicsIcon(GoogleMaterial.Icon.gmd_home)

        onClick = {
          findNavController().navigateToHome()
          false
        }
      }


      menu {
        title = "Change Test"
        subtitle = "Updates the model using onClick"
        var counter = 1

        onClick = {
          val model = menuViewModel()
          log.trace("change test on click child count: ${model.children.value?.size}")
          subtitle = "Counter: ${counter++}"
          model.invalidate()
          /*  model.children.value?.map { child ->
              @Suppress("LABEL_NAME_CLASH")
              if (child.id == this@menu.id) {
                //Found the child item
                //update the subtitle field of the builder to make the change persistant
                subtitle = "Counter: ${counter++}"

                //need to copy rather than modify for the [danbroid.util.menu.ui.MenuListAdapter]
                child.copy(subtitle = subtitle).also {
                  it.menuItemBuilder = child.menuItemBuilder
                }
              } else child
            }?.also {
              //update the model with the new children
              model.updateChildren(it)
            }*/
          true
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
    var count = 0

/*    onCreate = { item, model ->
      while (true) {
        count++
        item.title = "Menu 2: count: ${count}"
        model.updateItem(item)
        item.children = item.children?.mapIndexed { n, child ->
          child.copy(title = "Submenu: $n: Count: $count", subtitle = "${Date()}")
        }?.also {
          model.updateChildren(it)
        }

        delay(1000)
      }
    }*/

    onClick = {
      log.warn("ON CLICK")
      false
    }

    menu {
      title = "Submenu"
    }

    menu {
      title = "Submenu"
      menu {
        title = "Submenu"
      }
    }
  }

  iconExamples()

  permissionExamples()

  menu {
    id = DemoNavGraph.deep_link.settings
    title = "Settings"
    subtitle = "deeplink: $id"
    imageID = R.drawable.ic_settings
    onClick = promptToContinue

  }


}

private val promptToContinue: MenuItemClickHandler = {
  log.warn("promptToCOntinue")
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
  }
  log.warn("returning false")
  false
}

