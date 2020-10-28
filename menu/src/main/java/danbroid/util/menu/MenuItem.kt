package danbroid.util.menu

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.MenuRes

const val MENU_TINT_DISABLED = -1
const val MENU_TINT_DEFAULT = 0

data class MenuItem(
    var id: String,
    var title: String,
    var subtitle: String,
    var imageURI: String? = null,
    var icon: Drawable? = null,

    @MenuRes
    var contextMenuID: Int = 0,
    var isVisible: Boolean = true,
    var inlineChildren: Boolean = false,

    @ColorRes
    var tint: Int = MENU_TINT_DISABLED,
    var roundedCorners: Boolean = false
) {


  var menuItemBuilder: MenuItemBuilder? = null

  val isBrowsable: Boolean
    get() = menuItemBuilder?.isBrowsable == true

  var children: List<MenuItem>? = null
}


//private val log = org.slf4j.LoggerFactory.getLogger(MenuItem::class.java)
