package danbroid.util.prefs

/**
 * Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences] instance
 */


import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences] instance
 */

interface HasPrefs {
  val prefs: SharedPreferences
}

abstract class BasePref<T, K : Enum<*>>(val keyID: K, val defValue: T) {

  operator fun getValue(thisRef: HasPrefs, property: KProperty<*>): T =
      getPrefValue(thisRef)

  operator fun setValue(thisRef: HasPrefs, property: KProperty<*>, value: T) =
      setPrefValue(thisRef, value)

  abstract fun getPrefValue(hasPrefs: HasPrefs): T

  abstract fun setPrefValue(hasPrefs: HasPrefs, value: T)
}

class NullableStringPref<K : Enum<*>>(keyID: K, defValue: String?) :
    BasePref<String?, K>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
      hasPrefs.prefs.getString(keyID.name, defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: String?) =
      hasPrefs.prefs.edit().putString(keyID.name, value).apply()
}

class StringPref<K : Enum<*>>(keyID: K, defValue: String) :
    BasePref<String, K>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
      hasPrefs.prefs.getString(keyID.name, defValue)!!

  override fun setPrefValue(hasPrefs: HasPrefs, value: String): Unit {
    hasPrefs.prefs.edit().apply {
      putString(keyID.name, value)
      apply()
    }
  }
}

class IntPref<K : Enum<*>>(keyID: K, defValue: Int) : BasePref<Int, K>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
      hasPrefs.prefs.getInt(keyID.name, defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Int) =
      hasPrefs.prefs.edit().putInt(keyID.name, value).apply()
}

class LongPref<K : Enum<*>>(keyID: K, defValue: Long) : BasePref<Long, K>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
      hasPrefs.prefs.getLong(keyID.name, defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Long) =
      hasPrefs.prefs.edit().putLong(keyID.name, value).apply()
}


class BooleanPref<K : Enum<*>>(keyID: K, defValue: Boolean) :
    BasePref<Boolean, K>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
      hasPrefs.prefs.getBoolean(keyID.name, defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Boolean) =
      hasPrefs.prefs.edit().putBoolean(keyID.name, value).apply()
}


class FloatPref<K : Enum<*>>(keyID: K, defValue: Float) :
    BasePref<Float, K>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
      hasPrefs.prefs.getFloat(keyID.name, defValue)

  override fun setPrefValue(hasPrefs: HasPrefs, value: Float) =
      hasPrefs.prefs.edit().putFloat(keyID.name, value).apply()
}


class DoublePref<K : Enum<*>>(keyID: K, defValue: Double) :
    BasePref<Double, K>(keyID, defValue) {

  override fun getPrefValue(hasPrefs: HasPrefs) =
      hasPrefs.prefs.getString(keyID.name, null)?.toDouble() ?: defValue

  override fun setPrefValue(hasPrefs: HasPrefs, value: Double) =
      hasPrefs.prefs.edit().putString(keyID.name, value.toString()).apply()
}


@Suppress("UNCHECKED_CAST")
inline fun <reified T> SharedPreferences.get(key: String, defaultValue: T): T {
  when (T::class) {
    Boolean::class -> return this.getBoolean(key, defaultValue as Boolean) as T
    Float::class -> return this.getFloat(key, defaultValue as Float) as T
    Int::class -> return this.getInt(key, defaultValue as Int) as T
    Long::class -> return this.getLong(key, defaultValue as Long) as T
    String::class -> return this.getString(key, defaultValue as String) as T
    else -> {
      if (defaultValue is Set<*>) {
        return this.getStringSet(key, defaultValue as Set<String>) as T
      }
    }
  }

  return defaultValue
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T> SharedPreferences.put(key: String, value: T) {
  val editor = this.edit()

  when (T::class) {
    Boolean::class -> editor.putBoolean(key, value as Boolean)
    Float::class -> editor.putFloat(key, value as Float)
    Int::class -> editor.putInt(key, value as Int)
    Long::class -> editor.putLong(key, value as Long)
    String::class -> editor.putString(key, value as String)
    else -> {
      if (value is Set<*>) {
        editor.putStringSet(key, value as Set<String>)
      }
    }
  }

  editor.apply()
}

