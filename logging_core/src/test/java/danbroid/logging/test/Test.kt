package danbroid.logging.test

import danbroid.logging.LogConfig
import danbroid.logging.StdOutLog
import org.junit.Test


class Test {
  @Test
  fun test() {
    log.trace("This is my test!!")
    log.debug("This is my test!!")
    log.info("This is my test!!")
    log.warn("This is my test!!")
    log.error("This is my test!!",Exception("My exception"))
  }
}

private val log = danbroid.logging.configure("DEMO",StdOutLog,coloured = true)
