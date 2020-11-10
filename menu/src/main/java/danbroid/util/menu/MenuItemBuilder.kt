package danbroid.util.menu

import android.content.Context
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import danbroid.util.menu.model.menuViewModel
import danbroid.util.resource.toResourceURI


typealias MenuItemOnCreated = suspend Fragment.(item: MenuItem) -> Unit

typealias MenuItemClickHandler = suspend Fragment.() -> Boolean


class MenuItemBuilder(context: Context) : MenuBuilder(context) {


  @ColorRes
  var tintRes: Int = 0

  var onCreate: MenuItemOnCreated? = null

  var roundedCorners: Boolean = true

  var onClick: MenuItemClickHandler? = null

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
fun Fragment.invalidateMenu() = menuViewModel().invalidate(this)


//private val log = org.slf4j.LoggerFactory.getLogger(MenuItemBuilder::class.java)
