package danbroid.menu

import androidx.annotation.ColorInt
import androidx.annotation.MenuRes


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
    var isVisible:Boolean = true,
    var inlineChildren: Boolean = false,
    @Transient
    var menuItemBuilder: MenuItemBuilder?
) {

  @Transient
  var children: List<MenuItem>? = null

  @Transient
  @ColorInt
  var tint: Int = 0

  @Transient
  var source: Any? = null


}

private val log = org.slf4j.LoggerFactory.getLogger(MenuItem::class.java)
