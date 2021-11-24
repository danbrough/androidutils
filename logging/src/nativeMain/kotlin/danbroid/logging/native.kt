package danbroid.logging


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
      STACK_DEPTH = 5
      GET_LOG = { this.defaultLog }
    }.defaultLog!!


actual inline fun getStackTraceString(tr: Throwable?): String = tr?.stackTraceToString() ?: "null"

actual fun detailedDecorator(level: DBLog.Level, msg: String): String = "${level.toString().padStart(5,' ')}: $msg"




