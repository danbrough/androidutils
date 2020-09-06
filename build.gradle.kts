import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.jetbrains.dokka")
}

buildscript {

  dependencies {
    classpath("com.android.tools.build:gradle:4.1.0-rc02")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")

    classpath(AndroidX.navigation.safeArgsGradlePlugin)
  }

  repositories {
    google()
    jcenter()
    mavenCentral()
  }
}


//
//tasks {
//  val dokka by getting(DokkaTask::class) {
//    this.outputFormat = "gfm"
//
//    outputDirectory = "$rootDir/docs"
//
///*
//    subProjects =
//        listOf("demo", "permissions", "misc") //listOf("demo", "util", "permissions", "slf4j")
//*/
//
//
////    configuration {
////      jdkVersion = 8
////    }
//
//  }
//}

apply("project.gradle.kts")


allprojects {
  repositories {
    google()
    jcenter()
    //    maven { url 'https://jitpack.io' }
    maven("https://jitpack.io")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")

  }

  tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    dokkaSourceSets {
      configureEach {
        includes.from("README.MD")
      }
    }
  }
}



tasks.dokkaHtmlMultiModule {
  println("dokkaHtmlMultiModule")
  documentationFileName.set("Module.md")
}