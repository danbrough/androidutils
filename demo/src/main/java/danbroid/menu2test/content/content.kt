package danbroid.menu2test.content

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import danbroid.menu2test.DemoNavGraph
import danbroid.menu2test.R
import danbroid.menu2test.URI_CONTENT_PREFIX
import danbroid.util.menu.*
import danbroid.util.menu.model.menuViewModel
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory
import java.util.*

private val log = LoggerFactory.getLogger("danbroid.menu2test.content")
val rootContent = getRootMenu<MenuItemBuilder> {
  id = URI_CONTENT_PREFIX
  titleID = R.string.app_name

  menu {
    title = "Menu 1"
    subtitle = "subtitle for menu1"

    onClick = {
      Toast.makeText(context, "Opening menu:$id in 1 seconds", Toast.LENGTH_SHORT).show()
      delay(1000)
      it.invoke(true)
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
        title = "Sub-sub menu 1"
        subtitle = "calls navController?.navigateToHome()"
        onClick = {
          findNavController().navigateToHome()
        }
      }

      menu {
        title = "CHange Test"
        onClick = {
          val model = menuViewModel()
          log.trace("change test on click child count: ${model.children.value?.size}")
          model.children.value?.map { child ->
            if (child.id == this@menu.id) {
              child.copy(subtitle = "The date is ${Date()}").also {
                it.menuItemBuilder = child.menuItemBuilder
              }
            } else child
          }?.also {
            model.updateChildren(it)
          }
        }
      }


      menu {
        id = DemoNavGraph.deep_link.home
        title = "Sub-sub menu 1"
        subtitle = "uses deeplink ${DemoNavGraph.deep_link.home} as id"
      }
    }

  }

  menu {
    title = "Menu 2"
    subtitle = """imageURI = "https://picsum.photos/128"
roundedCorners = true"""
    imageURI = "https://picsum.photos/200"
    roundedCorners = true
    var count = 0

    onCreate = { item, model ->
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
    }

    onClick = promptToContinue

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


  menu {
    id = DemoNavGraph.deep_link.settings
    title = "Settings"
    subtitle = "deeplink: $id"
    imageID = R.drawable.ic_settings
    onClick = promptToContinue

  }


}

private val promptToContinue: MenuItemClickHandler = { callback ->
  AlertDialog.Builder(requireContext()).apply {
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