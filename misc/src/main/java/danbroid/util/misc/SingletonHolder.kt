package danbroid.util.misc


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

