import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

  dependencies {
    classpath(Libs.com_android_tools_build_gradle)
    classpath(Libs.kotlin_gradle_plugin)
    //classpath(Libs.navigation_safe_args_gradle_plugin)

  }

  repositories {
    google()
    jcenter()

  }
}

tasks.register("projectVersion") {
  this.description = "Prints the VERSION_NAME,VERSION_CODE from ProjectVersions"
  var versionCode = ProjectVersions.VERSION_CODE
  if (project.properties.containsKey("INCREMENT_VERSION")) {
    versionCode++
  }
  if (project.hasProperty("VERSION_CODE")) {
    versionCode = project.properties["VERSION_CODE"].toString().toInt()
  }
  println(ProjectVersions.getVersionName(versionCode))
}



plugins {
  buildSrcVersions
}

allprojects {
  repositories {
    google()
    jcenter()
    //    maven { url 'https://jitpack.io' }
    maven {
      setUrl("https://jitpack.io")
    }

  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      jvmTarget = "1.8"
      //freeCompilerArgs = listOf("-Xjsr305=strict")
      //freeCompilerArgs = listOf("-Xuse-experimental=kotlin.Experimental")
      //freeCompilerArgs = listOf("-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi")
    }
  }

}
