package danbroid.logging

import java.io.PrintWriter
import java.io.StringWriter
import java.net.UnknownHostException


object StdOutLog : DBLog {
  override var logName: String = "StdOutLog"

  @Suppress("OVERRIDE_BY_INLINE")
  override inline fun writeLogNative(
    name: String,
    level: DBLog.Level,
    msg: CharSequence?,
    error: Throwable?
  ) {
    println(msg)
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
): DBLog =
  LogConfig.apply {
    this.defaultLog = defaultLog ?: StdOutLog
    this.defaultLog!!.logName = tag
    MIN_LOG_LEVEL = minLogLevel
    DEBUG = debug
    COLOURED = coloured
    STACK_DEPTH = 4
    GET_LOG = { this.defaultLog }
  }.defaultLog!!


