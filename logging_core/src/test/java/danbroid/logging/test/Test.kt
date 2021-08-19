package danbroid.logging.test

import danbroid.logging.LogConfig
import org.junit.Test


class Test {
  @Test
  fun test() {
    log.info("This is my test!!")
  }
}

private val log = danbroid.logging.configure("DEMO").also {
  LogConfig.STACK_DEPTH = 4
}
