package danbroid.util.prefs.test


import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import danbroid.util.prefs.Prefs
import danbroid.util.prefs.edit
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*


@RunWith(AndroidJUnit4::class)
class PrefsTest {
  companion object {
    const val PREFS_FILE = "test_prefs"
    const val DEFAULT_COUNT = 33
    const val DEFAULT_TEMP = 12.3456f
    const val DEFAULT_FLAG = false
    const val DEFAULT_LONG = 12345678987654L
    const val DEFAULT_CHAR_SEQ = "hello world"
    const val DEFAULT_DOUBLE = 123456789.87654321
  }

  @ExperimentalStdlibApi
  class TestPrefs(context: Context) : Prefs(context, PREFS_FILE) {
    var message: String? by Pref(null)
    var count: Int by Pref(DEFAULT_COUNT)
    var temp: Float by Pref(DEFAULT_TEMP)
    var flag: Boolean by Pref(DEFAULT_FLAG)
    var bigLong: Long by Pref(DEFAULT_LONG)
    val readOnlyMessage: String by Pref("Default readonly message")
    var charSeq: CharSequence by Pref(DEFAULT_CHAR_SEQ)
    var dbl: Double by Pref(DEFAULT_DOUBLE)
  }

  @ExperimentalStdlibApi
  fun Context.testPrefs() = TestPrefs(this)

  @Test
  fun test() {
    log.info("test()")
    val context = InstrumentationRegistry.getInstrumentation().context
    var prefs = context.testPrefs()


    Assert.assertEquals("prefs.message should be null", null, prefs.message)
    Assert.assertEquals("prefs.count should be DEFAULT_COUNT", DEFAULT_COUNT, prefs.count)
    Assert.assertEquals("prefs.temp should be DEFAULT_TEMP", DEFAULT_TEMP, prefs.temp)
    Assert.assertEquals("prefs.flag should be DEFAULT_FLAG", DEFAULT_FLAG, prefs.flag)
    Assert.assertEquals("prefs.bigLong should be DEFAULT_LONG", DEFAULT_LONG, prefs.bigLong)
    Assert.assertEquals("prefs.charSeq should be DEFAULT_CHAR_SEQ", DEFAULT_CHAR_SEQ, prefs.charSeq)
    Assert.assertEquals("prefs.dbl should be DEFAULT_DOUBLE", DEFAULT_DOUBLE, prefs.dbl, 0.0)

    val newMessage = "The date is ${Date()}"


    prefs.edit(commit = true) {
      message = newMessage
      temp *= 2
      flag = !flag
      bigLong *= 3
      dbl *= 2.1
      count++
    }

    Assert.assertEquals("prefs.temp should be DEFAULT_TEMP + 1", DEFAULT_TEMP * 2, prefs.temp)
    Assert.assertEquals("prefs.count should be DEFAULT_COUNT + 1", DEFAULT_COUNT + 1, prefs.count)
    Assert.assertEquals("prefs.message should be newMessage", newMessage, prefs.message)
    Assert.assertEquals("prefs.flag should be !DEFAULT_FLAG", !DEFAULT_FLAG, prefs.flag)
    Assert.assertEquals("prefs.bigLong should be DEFAULT_LONG*3", DEFAULT_LONG * 3, prefs.bigLong)
    Assert.assertEquals("prefs.dbl should be DEFAULT_DOUBLE*2.1", DEFAULT_DOUBLE * 2.1, prefs.dbl, 0.0)

    prefs.edit(commit = true) {
      message = null
    }


    Assert.assertEquals("prefs.message should be null", null, prefs.message)

  }
}

private val log = org.slf4j.LoggerFactory.getLogger(PrefsTest::class.java)
