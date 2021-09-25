package danbroid.logging


fun configure(tag: String, defaultLog: DBLog = StdOutLog, minLogLevel: DBLog.Level? = null, debug: Boolean = true, coloured: Boolean = false): DBLog? {
  LogConfig.defaultLog = defaultLog.also {
    it.logName = tag
  }
  LogConfig.MIN_LOG_LEVEL = minLogLevel
  LogConfig.DEBUG = debug
  LogConfig.COLOURED = coloured
  LogConfig.GET_LOG = { LogConfig.defaultLog }
  return LogConfig.defaultLog
}

