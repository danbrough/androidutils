package danbroid.util.menu

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.MenuRes
import androidx.core.graphics.drawable.IconCompat
import danbroid.util.menu.model.MenuModel
import kotlin.reflect.KProperty


data class MenuItem(
    var id: String,
    var title: String,
    var subtitle: String,
    var imageURI: String? = null,
    var icon: Drawable? = null,

    @MenuRes
    var contextMenuID: Int = 0,
    var isBrowsable: Boolean = false,
    var isVisible: Boolean = true,
    var inlineChildren: Boolean = false,

    @ColorRes
    var tint: Int = TINT_DEFAULT,
    var roundedCorners: Boolean = false
) {
  companion object {
    const val TINT_DISABLED = -1
    const val TINT_DEFAULT = 0
  }

  var menuItemBuilder: MenuItemBuilder? = null

  var children: List<MenuItem>? = null
}


//private val log = org.slf4j.LoggerFactory.getLogger(MenuItem::class.java)
