package danbroid.util.misc

import java.lang.ref.WeakReference


/**
 * Usage:
 * ```kotlin
 * class Manager(context:Context) {
 * companion object : SingletonHolder<Manager,Context>(::Manager)
 * }
 * ```
 */
open class SingletonHolder<out T : Any, in A>(creator: (A) -> T) {
  private var creator: ((A) -> T)? = creator

  @Volatile
  private var instance: T? = null

  fun getInstance(arg: A): T = instance ?: synchronized(this) {
    instance ?: creator!!.invoke(arg).also {
      instance = it
      creator = null
    }
  }
}

/**
 * A singleton holder that uses a [WeakReference]
 */
open class WeakSingletonHolder<out T : Any, in A>(val creator: (A) -> T) {

  @Volatile
  private var instance: WeakReference<T>? = null

  fun getInstance(arg: A): T = instance?.get() ?: synchronized(this) {
    instance?.get() ?: creator.invoke(arg).also {
      instance = WeakReference(it)
    }
  }
}