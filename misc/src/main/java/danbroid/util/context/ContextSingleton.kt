package danbroid.util.context

import android.content.Context
import kotlin.reflect.full.createInstance

abstract class ContextSingleton {

  lateinit var context: Context

  companion object {

    @Volatile
    var INSTANCE: ContextSingleton? = null

    inline fun <reified T : ContextSingleton> getInstance(context: Context): T = INSTANCE as? T
        ?: synchronized(ContextSingleton::class) {
          INSTANCE as? T ?: T::class.createInstance().also {
            INSTANCE = it
            it.context = context.applicationContext
          }
        }
  }
}

