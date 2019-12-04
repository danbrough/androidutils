package danbroid.util.resource

import android.content.ContentResolver
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.net.Uri
import android.util.TypedValue
import android.widget.ImageView
import androidx.annotation.*
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import androidx.core.widget.ImageViewCompat

object ResourceUtils {

  fun toResourceURI(context: Context, @AnyRes resID: Int) =
    Uri.Builder()
      .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
      .authority(context.resources.getResourcePackageName(resID))
      .appendPath(context.resources.getResourceTypeName(resID))
      .appendPath(context.resources.getResourceEntryName(resID))
      .build()

  fun parseResourceURI(context: Context, uri: String?): Int {
    if (uri == null) return 0
    try {
      return parseResourceURI(context, Uri.parse(uri))
    } catch (err: Exception) {
    }
    return 0
  }

  fun parseResourceURI(context: Context, uri: Uri?): Int {
    if (uri == null) return 0
    try {
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
    parseResourceURI(context, s).let {
      if (it == 0) s
      else context.getString(it)
    }

  @DrawableRes
  fun resolveDrawableURI(context: Context, s: String?): Int =
    parseResourceURI(context, s)

  /**
   * Retrieves the [ColorInt] from your theme with the attribute identified by [themeColorAttribute]
   */
  @ColorInt
  fun getThemeColour(context: Context, @AttrRes themeColorAttribute: Int, @ColorInt defValue: Int = 0): Int =
    getAttribute(context, themeColorAttribute) {
      it.getColor(0, defValue)
    }

  /**
   * Retrieves the [Px] from your theme with the attribute identified by [dimensionAttribute]
   */
  @Px
  fun getDimensionPixelSize(
    context: Context, @AttrRes dimensionAttribute: Int,
    defValue: Int = 0
  ): Int = getAttribute(context, dimensionAttribute) {
    it.getDimensionPixelSize(0, defValue)
  }

  /**
   * Retrieves the [Px] from your theme with the attribute identified by [dimensionAttribute]
   */
  @Px
  fun getDimension(
    context: Context, @AttrRes dimensionAttribute: Int,
    defValue: Float = 0f
  ): Float =
    getAttribute(context, dimensionAttribute) {
      it.getDimension(0, defValue)
    }

  private fun <T> getAttribute(
    context: Context, @AttrRes attribute: Int,
    producer: (TypedArray) -> T
  ): T {
    val typedValue = TypedValue()
    val a = context.obtainStyledAttributes(typedValue.data, intArrayOf(attribute))
    return producer.invoke(a).also {
      a.recycle()
    }
  }


  @ColorInt
  fun getResourceColour(context: Context, @ColorRes colorId: Int): Int =
    ResourcesCompat.getColor(context.resources, colorId, context.theme)

}

fun ImageView.setTint(@ColorRes tint: Int) =
  ImageViewCompat.setImageTintList(
    this,
    if (tint != 0)
      ColorStateList.valueOf(
        ResourcesCompat.getColor(
          context.resources,
          tint,
          context.theme
        )
      )
    else null
  )

fun Int.toResourceURI(context: Context) = ResourceUtils.toResourceURI(context, this)

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

@ColorInt
fun Int.toThemeColour(context: Context): Int = ResourceUtils.getThemeColour(context, this)

@ColorInt
fun Int.toResourceColour(context: Context): Int = ResourceUtils.getResourceColour(context, this)

@Px
fun Context.getThemeDimension(@AttrRes themeDimensionAttr: Int, @Px defValue: Float = 0f) =
  ResourceUtils.getDimension(this, themeDimensionAttr, defValue)

@Px
fun Context.getThemeDimensionPixelSize(@AttrRes themeDimensionAttr: Int, @Px defValue: Int = 0) =
  ResourceUtils.getDimensionPixelSize(this, themeDimensionAttr, defValue)


/**
 * calls [resolveStringURI] and removes any html tags
 */
fun String?.toDisplayText(context: Context): String? {
  val s = this.resolveStringURI(context)
  if (s == null) return null
  return s.let {
    HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
  }
}
