package danbroid.util.context

import android.content.Context
import danbroid.util.context.Singleton.Companion.getInstance

abstract class Singleton<C>(val context: C) {

  companion object {

    @Volatile
    var INSTANCE: Singleton<*>? = null

    inline fun <C, reified T : Singleton<C>> getInstance(context: C): T = INSTANCE as? T
        ?: synchronized(T::class) {
          INSTANCE as? T ?: T::class.constructors.first().call(context).also {
            INSTANCE = it
          }
        }
  }
}


//inline fun <C : Any, reified T : Singleton<C>> C.singleton(): T = getInstance(this)
inline fun <reified T : Singleton<Context>> Context.singleton(): T = getInstance(this)



