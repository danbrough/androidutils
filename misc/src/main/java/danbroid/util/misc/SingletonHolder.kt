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

open class SingletonHolder2<out T : Any, in A,in B>(creator: (A,B) -> T) {
  private var creator: ((A,B) -> T)? = creator

  @Volatile
  private var instance: T? = null

  fun getInstance(arg1: A,arg2: B): T = instance ?: synchronized(this) {
    instance ?: creator!!.invoke(arg1,arg2).also {
      instance = it
      creator = null
    }
  }
}

open class SingletonHolder3<out T : Any, in A,in B,in C>(creator: (A,B,C) -> T) {
  private var creator: ((A,B,C) -> T)? = creator

  @Volatile
  private var instance: T? = null

  fun getInstance(arg1: A,arg2: B,arg3:C): T = instance ?: synchronized(this) {
    instance ?: creator!!.invoke(arg1,arg2,arg3).also {
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