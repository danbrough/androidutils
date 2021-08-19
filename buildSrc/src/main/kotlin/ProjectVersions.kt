import org.gradle.api.JavaVersion
import java.util.*


object ProjectVersions {
  const val SDK_VERSION = 31
  const val MIN_SDK_VERSION = 19
  const val BUILD_TOOLS_VERSION = "31.0.0"
  val JAVA_VERSION = JavaVersion.VERSION_1_8
  val KOTLIN_JVM_TARGET = "1.8"
  var BUILD_VERSION = 1
  var VERSION_OFFSET = 1
  const val GROUP_ID = "com.github.danbrough.androidutils"
  const val KEYSTORE_PASSWORD = ""
  var VERSION_FORMAT = ""

  val COMPOSE_VERSION = "1.1.0-alpha02"

  val VERSION_NAME: String
    get() = getVersionName()

  fun init(props: Properties) {
    BUILD_VERSION = props.getProperty("buildVersion", "1").toInt()
    VERSION_OFFSET = props.getProperty("versionOffset", "1").toInt()
    VERSION_FORMAT = props.getProperty("versionFormat", "0.0.%d").trim()
  }

  fun getIncrementedVersionName() = getVersionName(BUILD_VERSION + 1)


  fun getVersionName(version: Int = BUILD_VERSION) =
      VERSION_FORMAT.format(version - VERSION_OFFSET).trim()
}
