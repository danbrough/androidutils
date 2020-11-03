package danbroid.util.prefs

import android.content.Context
import android.content.SharedPreferences
import kotlin.reflect.KProperty
import kotlin.reflect.KType
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.typeOf

/**
 * Classes that allow you to implement properties that delegate to a [android.content.SharedPreferences] instance
 */


@Suppress("IMPLICIT_CAST_TO_ANY")
abstract class Prefs(val context: Context) {

  /**
   * val message:String by Pref("default value")
   * var count:Int? by Pref(null)
   */

  @ExperimentalStdlibApi
  inner class Pref(val defValue: Any?) {

    @Suppress("UNCHECKED_CAST")
    operator fun <T> getValue(thisRef: Prefs, property: KProperty<*>): T {
      return get(property.name, defValue, property.returnType) as T
    }

    operator fun <T> setValue(thisRef: Prefs, property: KProperty<*>, value: T) =
        put(property.name, value)

  }

  var _prefs: SharedPreferences? = null
  val prefs: SharedPreferences
    get() = _prefs ?: createPrefs().also {
      _prefs = it
    }

  protected abstract fun createPrefs(): SharedPreferences

  var _editor: SharedPreferences.Editor? = null
  val editor: SharedPreferences.Editor
    get() = _editor ?: prefs.edit().also {
      // log.error("created editor")
      _editor = it
    }


  fun clear(commit: Boolean = false) = editor.clear().also {
    if (commit) it.commit() else it.apply()
    _prefs = null
    _editor = null
  }

  companion object {
    //val log = LoggerFactory.getLogger(Prefs::class.java)
  }

  fun put(key: String, value: Any?) {
    // log.warn("setting pref: $key to $value")
    @Suppress("UNCHECKED_CAST")
    when (value) {
      null -> editor.remove(key)
      is CharSequence -> editor.putString(key, value.toString())
      is Double -> editor.putString(key, value.toString())
      is Long -> editor.putLong(key, value)
      is Float -> editor.putFloat(key, value)
      is Int -> editor.putInt(key, value)
      is Boolean -> editor.putBoolean(key, value)
      is Set<*> -> editor.putStringSet(key, value as Set<String>)
      else -> throw Exception("Cannot set property $key to $value")
    }
  }

  @ExperimentalStdlibApi
  fun get(key: String, defaultValue: Any?, type: KType): Any? {
    //log.error("get $key of type: $type default:$defaultValue")
    if (!prefs.contains(key)) {
      //log.error("$key not found: returning $defaultValue")
      return defaultValue
    }

    if (type.isSubtypeOf(typeOf<CharSequence>()) || type.isSubtypeOf(typeOf<CharSequence?>())) return prefs.getString(key, defaultValue?.toString())

    @Suppress("UNCHECKED_CAST")
    return when (type) {
      typeOf<Double>() -> java.lang.Double.parseDouble(prefs.getString(key, "")!!)
      typeOf<Int>() -> prefs.getInt(key, defaultValue as Int)
      typeOf<Float>() -> prefs.getFloat(key, defaultValue as Float)
      typeOf<Long>() -> prefs.getLong(key, defaultValue as Long)
      typeOf<Boolean>() -> prefs.getBoolean(key, defaultValue as Boolean)
      typeOf<Set<*>>() -> prefs.getStringSet(key, defaultValue as MutableSet<String>?)
      else -> throw IllegalArgumentException("Unsupported type: $type")
    }
  }

}

inline fun <T : Prefs> T.edit(commit: Boolean = true, block: T.() -> Unit) {
  block()
  _editor?.also {
    if (commit) it.commit() else it.apply()
    //Prefs.log.error("${if (commit) "committed" else "applyed"} transaction")
    _prefs = null
    _editor = null
  }
}






