package danbroid.util

import android.net.Uri

fun CharSequence.uriEncode(): String = Uri.encode(this.toString())
fun CharSequence.uriDecode(): String = Uri.decode(this.toString())
