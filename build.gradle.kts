import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.*

buildscript {


  dependencies {
    classpath(Libs.com_android_tools_build_gradle)
    classpath(Libs.kotlin_gradle_plugin)
    //classpath(Libs.navigation_safe_args_gradle_plugin)

  }

  repositories {
    google()
    jcenter()
    maven {
      setUrl("https://dl.bintray.com/kotlin/kotlin-eap")
    }
  }
}

plugins {
  buildSrcVersions
  id("org.jetbrains.dokka") version Versions.org_jetbrains_dokka_gradle_plugin
}


tasks {
  val dokka by getting(DokkaTask::class) {
    outputFormat = "gfm"
    outputDirectory = "$rootDir/docs"

    subProjects =
      listOf("demo", "permissions", "resource") //listOf("demo", "util", "permissions", "slf4j")


    configuration {
      jdkVersion = 8
    }

  }
}



allprojects {
  repositories {
    google()
    jcenter()
    //    maven { url 'https://jitpack.io' }
    maven {
      setUrl("https://jitpack.io")
    }
    maven {
      setUrl("https://dl.bintray.com/kotlin/kotlin-eap")
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

tasks.register("projectVersion") {
  this.description = "Prints Project.getVersionName()"
  doLast {
    println(ProjectVersions.getVersionName())
  }
}

tasks.register("nextProjectVersion") {
  this.description = "Prints Project.getIncrementedVersionName()"
  doLast {
    println(ProjectVersions.getIncrementedVersionName())
  }
}


