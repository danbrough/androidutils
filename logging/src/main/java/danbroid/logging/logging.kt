package danbroid.logging

import kotlin.reflect.KClass

abstract class Log {
  enum class Level {
    TRACE, DEBUG, INFO, WARN, ERROR
  }

  abstract val name: String

  fun trace(msg: CharSequence?, error: Throwable? = null) =
    write_log(Level.TRACE, msg, error)

  fun debug(msg: CharSequence?, error: Throwable? = null) =
    write_log(Level.DEBUG, msg, error)

  fun info(msg: CharSequence?, error: Throwable? = null) = write_log(Level.INFO, msg, error)
  fun warn(msg: CharSequence?, error: Throwable? = null) = write_log(Level.WARN, msg, error)
  fun error(msg: CharSequence?, error: Throwable? = null) =
    write_log(Level.ERROR, msg, error)

  fun write_log(level: Level, msg: CharSequence?, error: Throwable?) {
    LogConfig.MIN_LOG_LEVEL?.also { if (level < it) return }

    var newMsg = "$msg"

    if (LogConfig.DETAILED)
      newMsg = DetailedDecorator(level, newMsg)

    if (LogConfig.COLOURED)
      newMsg = ColouredDecorator(level, newMsg)

    write_log_native(
      name,
      level,
      LogConfig.MESSAGE_DECORATOR?.invoke(level, newMsg) ?: newMsg,
      error
    )
  }

  abstract fun write_log_native(
    name: String,
    level: Level,
    msg: CharSequence?,
    error: Throwable?
  )

}

object LogConfig {
  var MIN_LOG_LEVEL: Log.Level? = null

  var MESSAGE_DECORATOR: ((Log.Level, String) -> String)? = null

  var CLASS_TO_NAME: (KClass<*>) -> String = { it.qualifiedName!! }

  var COLOURED = false
  var DETAILED = true

  var GET_LOG: (String) -> Log? = { StdOutLog }

}


private fun Log.Level.colorInt(): Int = when (this) {
  Log.Level.TRACE -> 35
  Log.Level.DEBUG -> 36
  Log.Level.INFO -> 32
  Log.Level.WARN -> 33
  else -> 31
}


@Suppress("OVERRIDE_BY_INLINE")
private inline fun ColouredDecorator(level: Log.Level, msg: String): String =
  "\u001b[0;${level.colorInt()}m${msg}\u001b[0m"


@Suppress("OVERRIDE_BY_INLINE")
private inline fun DetailedDecorator(level: Log.Level, msg: String): String {
  val thread = Thread.currentThread()
  val stackElements = thread.stackTrace
  val element = stackElements[5]
  val header =
    "[<${thread.name}:${thread.id}>:${element.className}:${element.methodName}():${element.lineNumber}] "
  return "$header$msg"
}


@Suppress("OVERRIDE_BY_INLINE")
inline fun getLog(kclass: KClass<*>): Log = getLog(LogConfig.CLASS_TO_NAME(kclass))

@Suppress("OVERRIDE_BY_INLINE")
inline fun getLog(tag: String): Log = LogConfig.GET_LOG(tag) ?: NullLog

object NullLog : Log() {
  override val name: String = "NullLog"

  @Suppress("OVERRIDE_BY_INLINE")
  override inline fun write_log_native(
    name: String,
    level: Level,
    msg: CharSequence?,
    error: Throwable?
  ) {
  }

}

object StdOutLog : Log() {
  override val name: String = "StdOutLog"

  @Suppress("OVERRIDE_BY_INLINE")
  override inline fun write_log_native(
    name: String,
    level: Level,
    msg: CharSequence?,
    error: Throwable?
  ) {
    println(msg)
  }

}