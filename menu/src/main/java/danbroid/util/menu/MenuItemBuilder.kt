package danbroid.util.menu

import android.content.Context
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import danbroid.util.menu.model.menuViewModel
import danbroid.util.resource.toResourceURI


typealias MenuItemOnCreated = suspend Fragment.(item: MenuItem) -> Unit

class MenuItemClickContext(val fragment: Fragment, val action: MenuItemClickContext.() -> Unit) {
  fun requireContext() = fragment.requireContext()
  fun requireActivity() = fragment.requireActivity()
  fun findNavController() = fragment.findNavController()
  var consumed: Boolean = false
  fun proceed() = if (!consumed) action.invoke(this) else Unit
}


typealias MenuItemClickHandler = suspend MenuItemClickContext.() -> Unit


class MenuItemBuilder(context: Context) : MenuBuilder(context) {


  @ColorRes
  var tintRes: Int = 0

  var onCreate: MenuItemOnCreated? = null

  var roundedCorners: Boolean = true

  var onClick: MenuItemClickHandler? = null
  var onLongClick: MenuItemClickHandler? = null

  suspend fun createItem(fragment: Fragment, itemID: String = id, depth: Int = 1): MenuItem {
    val context = fragment.requireContext()
    val title = if (titleID != 0) context.getString(titleID) else title
        ?: context.getString(R.string.title_default_menu)
    val subtitle = if (subtitleID != 0) context.getString(subtitleID) else subtitle
    val image = if (imageID != 0) imageID.toResourceURI(context).toString() else imageURI
    return MenuItem(
        itemID,
        title,
        subtitle,
        image,
        icon?.invoke(context),
        isVisible
    ).also { item ->
      item.menuItemBuilder = this@MenuItemBuilder
      item.tint = tintRes
      item.roundedCorners = roundedCorners

      onCreate?.invoke(fragment, item)

      item.children = buildList { createChildren(fragment, this, depth) }.let {
        if (it.isEmpty()) null else it
      }
    }
  }


  private suspend fun createChildren(fragment: Fragment, items: MutableList<MenuItem>, depth: Int) {
    children?.forEach {
      val child = (it as MenuItemBuilder).createItem(fragment, it.id, if (it.inlineChildren) depth else depth - 1)
      if (it.inlineChildren) {
        child.children?.also {
          items.addAll(it)
        }
      } else {
        items.add(child)
      }
    }
  }

/*  fun createChildren(context: Context, item: MenuItem) {
    item.children = children?.filter { !it.inlineChildren }?.map {
      (it as MenuItemBuilder).createItem(context, it.id)
    }
  }*/

  override fun toString() = "MenuItemBuilder[$id:$title]"


}

@MenuDSL
fun MenuItemClickContext.invalidateMenu() = fragment.menuViewModel().invalidate(fragment)


//private val log = org.slf4j.LoggerFactory.getLogger(MenuItemBuilder::class.java)
