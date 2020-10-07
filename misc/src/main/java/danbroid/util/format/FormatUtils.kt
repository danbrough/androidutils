package danbroid.util.format

import android.annotation.SuppressLint
import java.text.CharacterIterator
import java.text.StringCharacterIterator

class FormatUtils {

  companion object {
    @SuppressLint("DefaultLocale")
    @JvmStatic
    fun humanReadableByteCount(bytes: Long): String {
      val absB = if (bytes == Long.MIN_VALUE) Long.MAX_VALUE else Math.abs(bytes)
      if (absB < 1024)
        return "$bytes B"

      var value = absB
      val ci: CharacterIterator = StringCharacterIterator("KMGTPE")
      var i = 40
      while (i >= 0 && absB > 0xfffccccccccccccL shr i) {
        value = value shr 10
        ci.next()
        i -= 10
      }
      value *= java.lang.Long.signum(bytes).toLong()
      return String.format("%.1f %ciB", value / 1024.0, ci.current())
    }
  }
}

fun Long.humanReadableByteCount() = FormatUtils.humanReadableByteCount(this)

//private val log = org.slf4j.LoggerFactory.getLogger(FormatUtils::class.java)
