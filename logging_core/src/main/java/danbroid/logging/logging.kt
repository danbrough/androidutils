package danbroid.logging

import danbroid.logging.LogConfig.STACK_DEPTH
import java.io.PrintWriter
import java.io.StringWriter
import java.net.UnknownHostException
import kotlin.reflect.KClass

interface DBLog {
  enum class Level {
    TRACE, DEBUG, INFO, WARN, ERROR
  }

  var logName: String

  fun dtrace(msg: CharSequence?, error: Throwable? = null) = write_log(Level.TRACE, msg, error, true)
  fun trace(msg: CharSequence?, error: Throwable? = null) = write_log(Level.TRACE, msg, error)

  fun ddebug(msg: CharSequence?, error: Throwable? = null) = write_log(Level.DEBUG, msg, error, true)
  fun debug(msg: CharSequence?, error: Throwable? = null) = write_log(Level.DEBUG, msg, error)

  fun dinfo(msg: CharSequence?, error: Throwable? = null) = write_log(Level.INFO, msg, error, true)
  fun info(msg: CharSequence?, error: Throwable? = null) = write_log(Level.INFO, msg, error)

  fun dwarn(msg: CharSequence?, error: Throwable? = null) = write_log(Level.WARN, msg, error, true)
  fun warn(msg: CharSequence?, error: Throwable? = null) = write_log(Level.WARN, msg, error)

  fun derror(msg: CharSequence?, error: Throwable? = null) = write_log(Level.ERROR, msg, error, true)
  fun error(msg: CharSequence?, error: Throwable? = null) = write_log(Level.ERROR, msg, error)


  private inline fun write_log(level: Level, msg: CharSequence?, error: Throwable?, debug: Boolean = false) {
    if (debug && !LogConfig.DEBUG) return

    LogConfig.MIN_LOG_LEVEL?.also { if (level < it) return }

    var newMsg = "$msg"

    if (LogConfig.DETAILED)
      newMsg = DetailedDecorator(level, newMsg)

    if (error != null) newMsg += ": " + getStackTraceString(error)

    if (LogConfig.COLOURED)
      newMsg = ColouredDecorator(level, newMsg)

    write_log_native(
        logName,
        level,
        LogConfig.MESSAGE_DECORATOR?.invoke(level, newMsg) ?: newMsg,
        error
    )
  }

  private inline fun getStackTraceString(tr: Throwable?): String? {
    if (tr == null) {
      return ""
    }

    // This is to reduce the amount of log spew that apps do in the non-error
    // condition of the network being unavailable.
    var t = tr
    while (t != null) {
      if (t is UnknownHostException) {
        return ""
      }
      t = t.cause
    }
    val sw = StringWriter()
    val pw = PrintWriter(sw)
    tr.printStackTrace(pw)
    pw.flush()
    return sw.toString()
  }

  fun write_log_native(
      name: String,
      level: Level,
      msg: CharSequence?,
      error: Throwable?
  )

}

object LogConfig {

  var DEBUG = true

  var MIN_LOG_LEVEL: DBLog.Level? = null

  var MESSAGE_DECORATOR: ((DBLog.Level, String) -> String)? = null

  /**
   * Coloured console output
   */
  var COLOURED = false

  /**
   * Apply the [DetailedDecorator]. default: true
   */
  var DETAILED = true

  var GET_LOG: (String) -> DBLog? = { StdOutLog }

  /**
   * How far to go back up the stack to get the line number and method name
   */
  var STACK_DEPTH = 5

  lateinit var defaultLog: DBLog

}


fun DBLog.Level.colorInt(): Int = when (this) {
  DBLog.Level.TRACE -> 35
  DBLog.Level.DEBUG -> 36
  DBLog.Level.INFO -> 32
  DBLog.Level.WARN -> 33
  else -> 31
}

fun configure(tag: String): DBLog {
  LogConfig.defaultLog = StdOutLog
  LogConfig.defaultLog.logName = tag
  LogConfig.DEBUG = true
  LogConfig.COLOURED = true
  LogConfig.GET_LOG = { LogConfig.defaultLog }
  return LogConfig.defaultLog
}


@Suppress("OVERRIDE_BY_INLINE")
fun ColouredDecorator(level: DBLog.Level, msg: String): String =
    "\u001b[0;${level.colorInt()}m${msg}\u001b[0m"


@Suppress("OVERRIDE_BY_INLINE")
inline fun DetailedDecorator(level: DBLog.Level, msg: String): String {
  val thread = Thread.currentThread()
  val stackElements = thread.stackTrace

  val element = stackElements[STACK_DEPTH]
  val header =
      "[<${thread.name}:${thread.id}>:${element.className}:${element.methodName}():${element.lineNumber}] "
  return "$header$msg"
}


@Suppress("OVERRIDE_BY_INLINE")
inline fun getLog(kclass: KClass<*>) = getLog(kclass.qualifiedName!!)

@Suppress("OVERRIDE_BY_INLINE")
inline fun getLog(tag: String) = LogConfig.GET_LOG(tag) ?: NullLog

object NullLog : DBLog {
  override var logName: String = "NullLog"

  @Suppress("OVERRIDE_BY_INLINE")
  override inline fun write_log_native(
      name: String,
      level: DBLog.Level,
      msg: CharSequence?,
      error: Throwable?
  ) {
  }

}

object StdOutLog : DBLog {
  override var logName: String = "StdOutLog"

  @Suppress("OVERRIDE_BY_INLINE")
  override inline fun write_log_native(
      name: String,
      level: DBLog.Level,
      msg: CharSequence?,
      error: Throwable?
  ) {
    println(msg)
  }

}


