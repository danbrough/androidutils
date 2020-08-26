import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

  dependencies {
    classpath("com.android.tools.build:gradle:4.2.0-alpha07")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
    classpath("digital.wup:android-maven-publish:3.6.3")
    classpath(AndroidX.navigation.safeArgsGradlePlugin)


  }

  repositories {
    google()
    jcenter()
    mavenCentral()
  }
}

plugins {
  id("org.jetbrains.dokka")
}


tasks {
  val dokka by getting(DokkaTask::class) {
    this.outputFormat = "gfm"

    outputDirectory = "$rootDir/docs"

/*
    subProjects =
        listOf("demo", "permissions", "misc") //listOf("demo", "util", "permissions", "slf4j")
*/


//    configuration {
//      jdkVersion = 8
//    }

  }
}

apply("project.gradle.kts")


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


