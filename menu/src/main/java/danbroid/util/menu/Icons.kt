package danbroid.util.menu

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.IIcon

typealias DrawableProvider = Context.() -> Drawable?

object Icons {
  @MenuDSL
  @JvmStatic
  fun resourceIcon(@DrawableRes resID: Int): DrawableProvider = {
    ResourcesCompat.getDrawable(resources, resID, theme)
  }

  @MenuDSL
  @JvmStatic
  fun iconicsIcon(icon: IIcon, builder: IconicsDrawable.() -> Unit = {}): DrawableProvider = {
    IconicsDrawable(this, icon).also(builder)
  }


}


/*
@MenuDSL
fun iconicsIcon(icon: IIcon, builder: IconicsDrawable.() -> Unit = {}) = Icons.iconicsIcon(icon, builder)
*/


