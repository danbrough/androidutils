package danbroid.logging

import kotlin.reflect.KClass

interface Log {
  enum class Level {
    TRACE, DEBUG, INFO, WARN, ERROR
  }

  fun trace(msg: CharSequence, error: Throwable? = null) = write_log(Level.TRACE, msg, error)
  fun debug(msg: CharSequence, error: Throwable? = null) = write_log(Level.DEBUG, msg, error)
  fun info(msg: CharSequence, error: Throwable? = null) = write_log(Level.INFO, msg, error)
  fun warn(msg: CharSequence, error: Throwable? = null) = write_log(Level.WARN, msg, error)
  fun error(msg: CharSequence, error: Throwable? = null) = write_log(Level.ERROR, msg, error)

  fun write_log(level: Level, msg: CharSequence, error: Throwable?)

}

object LogConfig {
  var MIN_LOG_LEVEL: Log.Level? = null

  var CREATE_LOG: (String) -> Log = { PrintlnImpl(it) }

  class NullLog : Log {
    override inline fun write_log(level: Log.Level, msg: CharSequence, error: Throwable?) {}
  }

  class PrintlnImpl(name: String) : LogImpl(name) {

    override fun write_log_native(level: Log.Level, msg: CharSequence, error: Throwable?) {
      println("$level: $msg ${error?.message}")
      error?.also {
        it.printStackTrace()
      }
    }
  }
}

abstract class LogImpl(val name: String) : Log {

  @Suppress("OVERRIDE_BY_INLINE")
  override final inline fun write_log(
      level: Log.Level,
      msg: CharSequence,
      error: Throwable?
  ) {
    LogConfig.MIN_LOG_LEVEL?.also {
      if (level < it) return
    }
    write_log_native(level, msg, error)
  }

  abstract fun write_log_native(level: Log.Level, msg: CharSequence, error: Throwable?)
}

fun createLog(name: String): Log = LogConfig.PrintlnImpl(name)

fun createLog(kclass: KClass<*>): Log = createLog(kclass.qualifiedName!!)

