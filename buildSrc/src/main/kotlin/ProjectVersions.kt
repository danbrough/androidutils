import org.gradle.api.JavaVersion
import org.gradle.api.Project
import java.util.*


object ProjectVersions {
  const val SDK_VERSION = 32
  const val MIN_SDK_VERSION = 19
  const val BUILD_TOOLS_VERSION = "32.0.0"
  val JAVA_VERSION = JavaVersion.VERSION_11
  val KOTLIN_JVM_VERSION = "11"
  var BUILD_VERSION = 1
  var VERSION_OFFSET = 1
  const val GROUP_ID = "com.github.danbrough.androidutils"
  const val KEYSTORE_PASSWORD = ""
  var VERSION_FORMAT = ""
  lateinit var MAVEN_REPO: String
  val COMPOSE_VERSION = "1.1.1"

  val VERSION_NAME: String
    get() = getVersionName()

  fun init(project: Project, props: Properties) {
    BUILD_VERSION = props.getProperty("buildVersion", "1").toInt()
    VERSION_OFFSET = props.getProperty("versionOffset", "1").toInt()
    VERSION_FORMAT = props.getProperty("versionFormat", "0.0.%d").trim()
    MAVEN_REPO = project.findProperty("LOCAL_MAVEN_REPO")?.toString()?.trim()
        ?: "https://h1.danbrough.org/maven"
  }


  fun getIncrementedVersionName() = getVersionName(BUILD_VERSION + 1)


  fun getVersionName(version: Int = BUILD_VERSION) =
      VERSION_FORMAT.format(version - VERSION_OFFSET).trim()
}
