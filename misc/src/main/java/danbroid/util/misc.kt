package danbroid.util

import android.net.Uri

fun CharSequence.uriEncode(allow: String? = null): String = if (allow != null) Uri.encode(this.toString(), allow) else Uri.encode(this.toString())
fun CharSequence.uriDecode(): String = Uri.decode(this.toString())
