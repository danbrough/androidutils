package danbroid.tests

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import org.junit.Test

@ExperimentalCoroutinesApi
class Test {

  @Test
  fun flowTest() {
    log.info("flowTest()")


  }
}


private val log = org.slf4j.LoggerFactory.getLogger(Test::class.java)
