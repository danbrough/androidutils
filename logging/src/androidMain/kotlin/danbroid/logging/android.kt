package danbroid.logging

import java.io.PrintWriter
import java.io.StringWriter
import java.net.UnknownHostException


class AndroidLog(override var logName: String) : DBLog {
  override fun writeLogNative(
    name: String,
    level: DBLog.Level,
    msg: CharSequence?,
    error: Throwable?
  ) {
    when (level) {
      DBLog.Level.TRACE -> android.util.Log.v(name, "$msg", error)
      DBLog.Level.DEBUG -> android.util.Log.d(name, "$msg", error)
      DBLog.Level.INFO -> android.util.Log.i(name, "$msg", error)
      DBLog.Level.WARN -> android.util.Log.w(name, "$msg", error)
      DBLog.Level.ERROR -> android.util.Log.e(name, "$msg", error)
    }
  }
}

@Suppress("OVERRIDE_BY_INLINE")
actual fun detailedDecorator(level: DBLog.Level, msg: String): String {
  val thread = Thread.currentThread()
  val stackElements = thread.stackTrace

  val element = stackElements[LogConfig.STACK_DEPTH]
  val header =
    "[<${thread.name}:${thread.id}>:${element.className}:${element.methodName}():${element.lineNumber}] "
  return "$header$msg"
}

actual inline fun getStackTraceString(tr: Throwable?): String {
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

  tr.printStackTrace()
  pw.flush()
  return sw.toString()
}

actual fun configure(
  tag: String,
  defaultLog: DBLog?,
  minLogLevel: DBLog.Level?,
  debug: Boolean,
  coloured: Boolean
): DBLog {
  LogConfig.defaultLog = defaultLog?.also {
    it.logName = tag
  } ?: AndroidLog(tag)
  LogConfig.MIN_LOG_LEVEL = minLogLevel
  LogConfig.DEBUG = debug
  LogConfig.COLOURED = coloured
  LogConfig.STACK_DEPTH = 5
  LogConfig.GET_LOG = { LogConfig.defaultLog }
  return LogConfig.defaultLog!!
}
