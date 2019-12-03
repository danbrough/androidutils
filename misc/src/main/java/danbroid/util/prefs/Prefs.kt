package danbroid.util.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringRes
import kotlin.reflect.KProperty

/**
 * Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences] instance
 */

interface HasPrefs {
  val prefs: SharedPreferences
  val prefsContext: Context
}

abstract class BasePref<T>(@StringRes val keyID: Int, val defValue: T) {

  operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
    getPrefValue(thisRef as HasPrefs)

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) =
    setPrefValue(thisRef as HasPrefs, value)

  abstract fun getPrefValue(hasPrefs: HasPrefs): T

  abstract fun setPrefValue(hasPrefs: HasPrefs, value: T)
}

class StringPref(@StringRes keyID: Int, defValue: String?) : BasePref<String?>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
    hasPrefs.prefs.getString(hasPrefs.key(keyID), defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: String?) =
    hasPrefs.prefs.edit().putString(hasPrefs.key(keyID), value).apply()
}


class DoublePref(@StringRes key: Int, defValue: Double) : BasePref<Double>(key, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
    hasPrefs.prefs.getString(hasPrefs.key(keyID), null)?.let {
      java.lang.Double.parseDouble(it)
    } ?: defValue


  override fun setPrefValue(hasPrefs: HasPrefs, value: Double) =
    hasPrefs.prefs.edit().putString(hasPrefs.key(keyID), value.toString()).apply()
}


class FloatPref(@StringRes key: Int, defValue: Float) : BasePref<Float>(key, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
    hasPrefs.prefs.getFloat(hasPrefs.key(keyID), defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Float) =
    hasPrefs.prefs.edit().putFloat(hasPrefs.key(keyID), value).apply()
}


class IntPref(@StringRes key: Int, defValue: Int) : BasePref<Int>(key, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
    hasPrefs.prefs.getInt(hasPrefs.key(keyID), defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Int) =
    hasPrefs.prefs.edit().putInt(hasPrefs.key(keyID), value).apply()
}

class LongPref(@StringRes key: Int, defValue: Long) : BasePref<Long>(key, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
    hasPrefs.prefs.getLong(hasPrefs.key(keyID), defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Long) =
    hasPrefs.prefs.edit().putLong(hasPrefs.key(keyID), value).apply()
}

class BooleanPref(@StringRes key: Int, defValue: Boolean) : BasePref<Boolean>(key, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
    hasPrefs.prefs.getBoolean(hasPrefs.key(keyID), defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Boolean) =
    hasPrefs.prefs.edit().putBoolean(hasPrefs.key(keyID), value).apply()
}

fun HasPrefs.key(@StringRes keyID: Int) = prefsContext.getString(keyID)


//private val log = org.slf4j.LoggerFactory.getLogger(Prefs::class.java)