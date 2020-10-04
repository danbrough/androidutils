package danbroid.util.menu

import android.content.Context
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import danbroid.util.menu.ui.model.MenuListModel
import danbroid.util.resource.toResourceURI

typealias LiveItemProducer = suspend (context: Context, id: String, oldItem: MenuItem?) -> MenuItem?
typealias LiveChildrenProducer = suspend (context: Context, id: String, oldItem: MenuItem?) -> List<MenuItem>?

class MenuActionContext(
  val context: Context,
  val menuItem: MenuItem,
  val fragment: Fragment? = null
) {
  val navController: NavController?
    get() = fragment?.findNavController()
}

typealias MenuItemClickHandler = suspend MenuActionContext.((Boolean) -> Unit) -> Unit

class MenuItemBuilder : MenuBuilder() {

  @ColorRes
  var tintRes: Int = 0

  var liveItem: LiveItemProducer? = null

  var liveChildren: LiveChildrenProducer? = null

  var roundedCorners: Boolean = true

  var onClick: MenuItemClickHandler? = null

  var onCreate: (MenuItem.(Context) -> Unit)? = null

  var onCreateModel: ((MenuListModel) -> Unit)? = null

  var onClearedModel: ((MenuListModel) -> Unit)? = null

  fun createItem(context: Context, itemID: String = id!!): MenuItem {
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
      this
    ).also {
      it.tint = tintRes
      it.children = children?.filter { !it.inlineChildren }?.map {
        (it as MenuItemBuilder).createItem(context, it.id!!)
      }
      onCreate?.invoke(it, context)
    }
  }


}


private val log = org.slf4j.LoggerFactory.getLogger(MenuItemBuilder::class.java)
