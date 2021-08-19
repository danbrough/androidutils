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


fun configureAndroid(tag: String) :DBLog {
  LogConfig.defaultLog = AndroidLog(tag)
  LogConfig.DEBUG = BuildConfig.DEBUG
  LogConfig.COLOURED = true
  LogConfig.STACK_DEPTH = 5
  LogConfig.GET_LOG = { LogConfig.defaultLog }
  return LogConfig.defaultLog
}

