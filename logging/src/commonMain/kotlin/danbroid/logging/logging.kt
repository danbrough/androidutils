package danbroid.logging

import kotlin.reflect.KClass

interface DBLog {
  enum class Level {
    TRACE, DEBUG, INFO, WARN, ERROR
  }

  var logName: String

  fun dtrace(msg: CharSequence?, error: Throwable? = null) =
    writelog(Level.TRACE, msg, error, true)

  fun trace(msg: CharSequence?, error: Throwable? = null) = writelog(Level.TRACE, msg, error)

  fun ddebug(msg: CharSequence?, error: Throwable? = null) = writelog(Level.DEBUG, msg, error, true)

  fun debug(msg: CharSequence?, error: Throwable? = null) = writelog(Level.DEBUG, msg, error)

  fun dinfo(msg: CharSequence?, error: Throwable? = null) = writelog(Level.INFO, msg, error, true)
  fun info(msg: CharSequence?, error: Throwable? = null) = writelog(Level.INFO, msg, error)

  fun dwarn(msg: CharSequence?, error: Throwable? = null) = writelog(Level.WARN, msg, error, true)
  fun warn(msg: CharSequence?, error: Throwable? = null) = writelog(Level.WARN, msg, error)

  fun derror(msg: CharSequence?, error: Throwable? = null) = writelog(Level.ERROR, msg, error, true)

  fun error(msg: CharSequence?, error: Throwable? = null) = writelog(Level.ERROR, msg, error)


  private inline fun writelog(
    level: Level,
    msg: CharSequence?,
    error: Throwable?,
    debug: Boolean = false
  ) {
    if (debug && !LogConfig.DEBUG) return

    LogConfig.MIN_LOG_LEVEL?.also { if (level < it) return }

    var newMsg = "$msg"

    if (LogConfig.DETAILED)
      newMsg = detailedDecorator(level, newMsg)

    if (error != null) newMsg += ": " + getStackTraceString(error)

    if (LogConfig.COLOURED)
      newMsg = colouredDecorator(level, newMsg)

    writeLogNative(
      logName,
      level,
      LogConfig.MESSAGE_DECORATOR?.invoke(level, newMsg) ?: newMsg,
      error
    )
  }


  fun writeLogNative(
    name: String,
    level: Level,
    msg: CharSequence?,
    error: Throwable?
  )

}


expect inline fun getStackTraceString(tr: Throwable?): String

object LogConfig {

  /**
   * Whether the [DBLog.dtrace],[DBLog.ddebug] .. functions are enabled.
   */
  var DEBUG = true

  /**
   * The default return value of [GET_LOG]. default: null
   */
  var defaultLog: DBLog? = null

  var MIN_LOG_LEVEL: DBLog.Level? = null

  var MESSAGE_DECORATOR: ((DBLog.Level, String) -> String)? = null

  /**
   * Coloured console output
   */
  var COLOURED = false

  /**
   * Apply the [detailedDecorator]. default: true
   */
  var DETAILED = true

  var GET_LOG: (String) -> DBLog? = { defaultLog }

  /**
   * How far to go back up the stack to get the line number and method name
   */
  var STACK_DEPTH = 4


}


fun DBLog.Level.colorInt(): Int = when (this) {
  DBLog.Level.TRACE -> 35
  DBLog.Level.DEBUG -> 36
  DBLog.Level.INFO -> 32
  DBLog.Level.WARN -> 33
  else -> 31
}


@Suppress("OVERRIDE_BY_INLINE")
fun colouredDecorator(level: DBLog.Level, msg: String): String =
  "\u001b[0;${level.colorInt()}m${msg}\u001b[0m"


inline fun getLog(kclass: KClass<*>) = getLog(kclass.qualifiedName!!)

inline fun getLog(tag: String) = LogConfig.GET_LOG(tag) ?: NoOpLog

object NoOpLog : DBLog {
  override var logName: String = "NoOpLog"

  @Suppress("OVERRIDE_BY_INLINE")
  override inline fun writeLogNative(
    name: String,
    level: DBLog.Level,
    msg: CharSequence?,
    error: Throwable?
  ) = Unit

}

expect fun detailedDecorator(level: DBLog.Level, msg: String): String


expect fun configure(
  tag: String,
  defaultLog: DBLog? = null,
  minLogLevel: DBLog.Level? = null,
  debug: Boolean = false,
  coloured: Boolean = false
): DBLog