package danbroid.util.menu

import androidx.annotation.ColorRes
import androidx.annotation.MenuRes
import danbroid.util.menu.model.MenuModel
import kotlin.reflect.KProperty


data class MenuItem(
    var id: String,
    var title: String,
    var subtitle: String,
    var imageURI: String? = null,

    @MenuRes
    var menuID: Int = 0,

    @MenuRes
    var contextMenuID: Int = 0,
    var isBrowsable: Boolean = false,
    var isVisible: Boolean = true,
    var inlineChildren: Boolean = false,

    @ColorRes
    var tint: Int = 0,
    var roundedCorners: Boolean = false
) {


  var menuItemBuilder: MenuItemBuilder? = null

  var children: List<MenuItem>? = null
}


//private val log = org.slf4j.LoggerFactory.getLogger(MenuItem::class.java)
