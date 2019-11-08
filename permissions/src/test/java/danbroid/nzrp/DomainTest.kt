package danbroid.nzrp

import danbroid.media.domain.MediaItem
import org.junit.Test

class DomainTest {
  @Test
  fun test() {
    log.warn("RUNNING THE DOMAIN TES@wwww@@T!")
    val mediaItem = danbroid.media.domain.MediaItem("1", "FIrst Item")
    log.debug("created $mediaItem")
  }
}

fun main() {
  DomainTest().test()
}

private val log = org.slf4j.LoggerFactory.getLogger(DomainTest::class.java)

