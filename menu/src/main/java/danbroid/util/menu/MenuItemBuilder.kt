package danbroid.util.menu

import android.content.Context
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import danbroid.util.menu.model.MenuModel
import danbroid.util.resource.toResourceURI


typealias LiveItemProducer = suspend MenuModel.(item: MenuItem) -> Unit

typealias MenuItemClickHandler = suspend MenuModel.(continueNavigation: (Boolean) -> Unit) -> Unit

class MenuItemBuilder : MenuBuilder() {

  @ColorRes
  var tintRes: Int = 0

  var onCreate: LiveItemProducer? = null

  var liveChildren: LiveItemProducer? = null

  var roundedCorners: Boolean = true

  var onClick: MenuItemClickHandler? = null

  override var isBrowsable: Boolean
    get() = super.isBrowsable || liveChildren != null
    set(value) {
      super.isBrowsable = value
    }


  fun createItem(context: Context, itemID: String = id, depth: Int = 1): MenuItem {
    val title = if (titleID != 0) context.getString(titleID) else title
        ?: context.getString(R.string.title_default_menu)
    val subtitle = if (subtitleID != 0) context.getString(subtitleID) else subtitle
    val image = if (imageID != 0) imageID.toResourceURI(context).toString() else imageURI
    return MenuItem(
        itemID,
        title,
        subtitle,
        image,
        menuID,
        contextMenuID,
        isBrowsable,
        isVisible,
        inlineChildren,
    ).also { item ->
      item.menuItemBuilder = this@MenuItemBuilder
      item.tint = tintRes
      item.roundedCorners = roundedCorners
      if (depth > 0)
        item.children = children?.filter { !it.inlineChildren }?.map {
          (it as MenuItemBuilder).createItem(context, it.id, depth - 1)
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


private val log = org.slf4j.LoggerFactory.getLogger(MenuItemBuilder::class.java)
