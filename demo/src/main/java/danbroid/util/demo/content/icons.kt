package danbroid.util.demo.content

import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import com.mikepenz.iconics.utils.backgroundColorRes
import com.mikepenz.iconics.utils.backgroundContourColorRes
import com.mikepenz.iconics.utils.backgroundContourWidth
import com.mikepenz.iconics.utils.colorRes
import danbroid.util.demo.R
import danbroid.util.demo.URI_CONTENT_PREFIX
import danbroid.util.menu.*
import danbroid.util.menu.Icons.iconicsIcon
import danbroid.util.menu.Icons.resourceIcon

internal fun MenuItemBuilder.iconExamples() =
    menu {

      id = "$URI_CONTENT_PREFIX/icons"
      title = "Icon Examples"
      subtitle = "Examples of how to configure the icon"
      imageURI = "https://picsum.photos/128?b"

      menu {
        title = "Icon by imageID"
        subtitle = "imageID = R.drawable.ic_folder_open"
        imageID = R.drawable.ic_folder_open
      }

      menu {
        title = "Icon with tint"
        subtitle = "tintRes = R.color.colorAccent"
        tintRes = R.color.colorAccent
      }

      menu {
        title = "Rounded Corners"
        subtitle = "roundedCorners = true"
        imageURI = "https://picsum.photos/128?c"
        roundedCorners = true
      }

      menu {
        title = "Square Corners"
        subtitle = "roundedCorners = false"
        imageURI = "https://picsum.photos/128?c"
        roundedCorners = false
      }

      menu {
        title = "Resource ID Icon"
        subtitle = "icon = R.drawable.ic_audiotrack.toResourceIDIcon()"
        icon = resourceIcon(R.drawable.ic_audiotrack)
      }

      menu {
        title = "Iconics Icon"
        subtitle = "icon = Icons.iconicsIcon(GoogleMaterial.Icon.gmd_shopping_cart)"
        icon = iconicsIcon(GoogleMaterial.Icon.gmd_shopping_cart)
      }

      menu {
        title = "Iconics Icon"
        subtitle = "icon = Icons.iconicsIcon(FontAwesome.Icon.faw_air_freshener)"
        //disable default tint
        tintRes = MENU_TINT_DISABLED
        icon = iconicsIcon(FontAwesome.Icon.faw_air_freshener) {
          colorRes = R.color.colorAccent
          backgroundColorRes = R.color.colorPrimaryLight
          backgroundContourWidth = IconicsSize.dp(2)
          backgroundContourColorRes = R.color.colorPrimary
        }
      }

    }