package danbroid.util.resource

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat

class ResourceUtils {
  companion object {

    fun resourceURI(context: Context, resID: Int) =
        Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(context.resources.getResourcePackageName(resID))
            .appendPath(context.resources.getResourceTypeName(resID))
            .appendPath(context.resources.getResourceEntryName(resID))
            .build()

    fun parseResourceURL(context: Context, url: String?): Int {
      if (url == null) return 0
      try {
        val uri = Uri.parse(url)
        if (uri.scheme == ContentResolver.SCHEME_ANDROID_RESOURCE) {
          val segments = uri.pathSegments
          val resourceName = segments.last()
          val typeName = segments[segments.size - 2]
          return context.resources.getIdentifier(resourceName, typeName, uri.host)
        }
      } catch (err: Exception) {
      }
      return 0
    }

    fun resolveStringURI(context: Context, s: String?): String? =
        parseResourceURL(context, s).let {
          if (it == 0) s
          else context.getString(it)
        }

    @DrawableRes
    fun resolveDrawableURI(context: Context, s: String?): Int =
        parseResourceURL(context, s)

    @ColorInt
    fun getThemeColour(context: Context, @AttrRes themeColorAttribute: Int): Int {
      val typedValue = TypedValue()
      val a = context.obtainStyledAttributes(typedValue.data, intArrayOf(themeColorAttribute))
      val color = a.getColor(0, 0)
      a.recycle()
      return color
    }

    @ColorInt
    fun getResourceColour(context: Context, @ColorRes colorId: Int): Int {
      return ResourcesCompat.getColor(context.resources, colorId, null)
    }
  }
}


fun Int.toStringURI(context: Context) = ResourceUtils.resourceURI(context, this)

fun Int.toDrawableURI(context: Context) = ResourceUtils.resourceURI(context, this)


fun String?.resolveStringURI(context: Context): String? =
    ResourceUtils.resolveStringURI(context, this)

fun String?.resolveDrawableURI(context: Context): Int =
    ResourceUtils.resolveDrawableURI(context, this)

@ColorInt
fun Context.getThemeColour(@AttrRes themeColorAttribute: Int) =
    ResourceUtils.getThemeColour(this, themeColorAttribute)

@ColorInt
fun Context.getResourceColour(@ColorRes colorID: Int) =
    ResourceUtils.getResourceColour(this, colorID)

fun String?.toDisplayText(context: Context): String? {
  val s = this.resolveStringURI(context)
  if (s == null) return null
  return s.let {
    HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
  }
}
