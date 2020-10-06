package danbroid.util

import android.annotation.SuppressLint
import android.net.Uri
import java.text.CharacterIterator
import java.text.StringCharacterIterator

fun CharSequence.uriEncode(allow: String? = null): String = if (allow != null) Uri.encode(
  this.toString(),
  allow
) else Uri.encode(this.toString())

fun CharSequence.uriDecode(): String = Uri.decode(this.toString())



//string[] sizes = { "B", "KB", "MB", "GB", "TB" };
//double len = new FileInfo(filename).Length;
//int order = 0;
//while (len >= 1024 && order < sizes.Length - 1) {
//    order++;
//    len = len/1024;
//}