package danbroid.logging

import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

class Slf4jLogImpl(kclass: KClass<*>) : LogImpl(kclass.qualifiedName!!) {
  val log = LoggerFactory.getLogger(name)

  override inline fun write_log_native(level: Log.Level, msg: CharSequence, error: Throwable?) {
    when (level) {
      Log.Level.TRACE -> log.trace(msg.toString(), error)
      Log.Level.DEBUG -> log.debug(msg.toString(), error)
      Log.Level.INFO -> log.info(msg.toString(), error)
      Log.Level.WARN -> log.warn(msg.toString(), error)
      Log.Level.ERROR -> log.error(msg.toString(), error)
    }
  }
}