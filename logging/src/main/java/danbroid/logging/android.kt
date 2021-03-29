package danbroid.logging

class AndroidLog(override val name: String) : Log() {
  override inline fun write_log_native(
    name: String,
    level: Level,
    msg: CharSequence?,
    error: Throwable?
  ) {
    when (level) {
      Log.Level.TRACE -> android.util.Log.v(name, "$msg", error)
      Log.Level.DEBUG -> android.util.Log.d(name, "$msg", error)
      Log.Level.INFO -> android.util.Log.i(name, "$msg", error)
      Log.Level.WARN -> android.util.Log.w(name, "$msg", error)
      Log.Level.ERROR -> android.util.Log.e(name, "$msg", error)
    }
  }
}