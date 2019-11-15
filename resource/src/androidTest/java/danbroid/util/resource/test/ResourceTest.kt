package danbroid.util.resource.test

import androidx.test.platform.app.InstrumentationRegistry
import danbroid.util.resource.R
import danbroid.util.resource.ResourceUtils
import danbroid.util.resource.toURI
import org.junit.Assert

class ResourceTest {
  @org.junit.Test
  fun test1() {
    val context = InstrumentationRegistry.getInstrumentation().context
    val resID1 = R.string.app_name
    log.info("resID is $resID1")
    val resourceURI = resID1.toURI(context)
    log.info("resourceURI  is $resourceURI")
    val resID2 = ResourceUtils.parseResourceURI(context, resourceURI)
    Assert.assertEquals(resID1, resID2)
  }
}

private val log = org.slf4j.LoggerFactory.getLogger(ResourceTest::class.java)

