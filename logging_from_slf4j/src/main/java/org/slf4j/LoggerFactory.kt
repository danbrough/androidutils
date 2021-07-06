package org.slf4j

class LoggerFactory {
  companion object {
    @JvmStatic
    fun getLogger(name: String) = danbroid.logging.getLog(name)

    @JvmStatic
    fun getLogger(clz: Class<*>) = danbroid.logging.getLog(clz.canonicalName)
  }
}


