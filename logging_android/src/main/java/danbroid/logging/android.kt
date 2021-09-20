package danbroid.logging

class AndroidLog(override var logName: String) : DBLog {
  override fun write_log_native(
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

fun configure(tag: String, defaultLog: DBLog = AndroidLog(tag), minLogLevel: DBLog.Level? = null, debug: Boolean = BuildConfig.DEBUG, coloured: Boolean = false): DBLog {
  LogConfig.defaultLog = defaultLog
  LogConfig.DEBUG = debug
  LogConfig.COLOURED = coloured
  LogConfig.STACK_DEPTH = 5
  LogConfig.GET_LOG = { LogConfig.defaultLog }
  return LogConfig.defaultLog
}