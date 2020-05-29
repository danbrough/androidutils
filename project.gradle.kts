import java.io.FileInputStream
import java.util.*

fun initProps() {
  //println("initProps()")
  val fis = FileInputStream("project.properties")
  val prop = Properties()
  prop.load(fis)
  fis.close()

  prop.keys.forEach {
    val key = it as String
    extra[key] = prop[key]
  }

  ProjectVersions.init(prop)
}



initProps()

class ProjectPlugin : Plugin<Project> {
  fun incrementVersion() {
    val fis = FileInputStream("project.properties")
    val prop = Properties()
    prop.load(fis)
    fis.close()
    val version = prop.getProperty("buildVersion", "0").toInt()
    println("version $version")
    prop.setProperty("buildVersion", "${version + 1}")
    val fos = java.io.PrintWriter(java.io.FileWriter("project.properties"))
    prop.store(fos, "")
    fos.println()
    fos.close()
  }

  override fun apply(project: Project) {

    project.task("projectVersionName") {
      doLast {
        println(ProjectVersions.getVersionName())
      }
    }

    project.task("projectNextVersionName") {
      doLast {
        println(ProjectVersions.getIncrementedVersionName())
      }
    }

    project.task("projectIncrementVersion") {
      doLast {
        incrementVersion()
      }
    }
  }
}

// Apply the plugin
apply<ProjectPlugin>()