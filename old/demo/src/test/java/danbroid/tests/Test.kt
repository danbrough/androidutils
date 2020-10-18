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
    runBlocking {
      log.warn("flow test")
      val flow1 = channelFlow {
        launch(Dispatchers.IO) {
          repeat(5) {
            log.trace("emitting msg: $it")
            send("Msg $it")
            delay(1000)
          }
        }
      }
      launch(Dispatchers.IO) {
        log.info("background launch")
        flow1.collect {
          log.trace("background collected flow1: $it")
        }
      }

      log.info("collecting on flow1")
      flow1.collect {
        log.debug("collected flow1: $it")
      }
      log.info("finished collecting flow 1")
    }
  }
}


private val log = org.slf4j.LoggerFactory.getLogger(Test::class.java)
