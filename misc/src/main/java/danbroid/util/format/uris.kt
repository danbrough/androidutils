package danbroid.util.format

import android.net.Uri

/**
 * Calls [android.net.Uri#encode] on the string
 */
fun CharSequence.uriEncode(allow: String? = null): String = if (allow != null) Uri.encode(
  this.toString(),
  allow
) else Uri.encode(this.toString())

/**
 * Calls [android.net.Uri#decode] on the string
 */
fun CharSequence.uriDecode(): String = Uri.decode(this.toString())

