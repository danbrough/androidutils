package danbroid.logging


import org.slf4j.LoggerFactory

class Slf4jLogImpl(override var logName: String) : DBLog {

  val log = LoggerFactory.getLogger(logName)

  override inline fun write_log_native(
    name: String,
    level: DBLog.Level,
    msg: CharSequence?,
    error: Throwable?
  ) {
    when (level) {
      DBLog.Level.TRACE -> log.trace(msg.toString(), error)
      DBLog.Level.DEBUG -> log.debug(msg.toString(), error)
      DBLog.Level.INFO -> log.info(msg.toString(), error)
      DBLog.Level.WARN -> log.warn(msg.toString(), error)
      DBLog.Level.ERROR -> log.error(msg.toString(), error)
    }
  }


}
