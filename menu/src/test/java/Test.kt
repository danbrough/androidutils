import java.util.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class SharedPrefs {
  val map = mutableMapOf<String, Any>()

  val message: String by Pref("default message")
  var title: String? by Pref(null)
  val count: Int by Pref(0)


  protected open inner class Pref<T>(val defValue: T) {

    @Suppress("UNCHECKED_CAST")
    operator fun getValue(thisRef: SharedPrefs, property: KProperty<*>): T =
        map.getOrDefault(property.name, defValue) as T

    operator fun setValue(thisRef: SharedPrefs, property: KProperty<*>, value: T) {
      map.put(property.name, value!!)
    }

  }


}


fun SharedPrefs.prefsTransaction(block: SharedPrefs.() -> Unit) {
  block()

}


class Test {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      println("The date is ${Date()}")
      val prefs = SharedPrefs()

      prefs.prefsTransaction {
        println("Message is ${message}")
        println("Title is $title")
        title = "New title"
        println("New is $title")
      }
    }
  }
}

//private val log = org.slf4j.LoggerFactory.getLogger(Test::class.java)
