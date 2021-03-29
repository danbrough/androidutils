package danbroid.logging


import org.slf4j.LoggerFactory

class Slf4jLogImpl(override val name: String) : Log() {

  val log = LoggerFactory.getLogger(name)

  override inline fun write_log_native(
    name: String,
    level: Log.Level,
    msg: CharSequence?,
    error: Throwable?
  ) {
    when (level) {
      Log.Level.TRACE -> log.trace(msg.toString(), error)
      Log.Level.DEBUG -> log.debug(msg.toString(), error)
      Log.Level.INFO -> log.info(msg.toString(), error)
      Log.Level.WARN -> log.warn(msg.toString(), error)
      Log.Level.ERROR -> log.error(msg.toString(), error)
    }
  }


}
