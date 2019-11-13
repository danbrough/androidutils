package stdout

class Log {
  fun test(){
    log.warn("it worked")
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(Log::class.java)

