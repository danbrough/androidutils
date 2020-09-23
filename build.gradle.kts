plugins {
  id("org.jetbrains.dokka")
}

buildscript {

  dependencies {
    classpath("com.android.tools.build:gradle:4.2.0-alpha12")
    //classpath("com.android.tools.build:gradle:4.1.0-rc03")
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


subprojects {
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
        includes.from("README.md")
      }
    }
  }


}



tasks.dokkaHtmlMultiModule {
  println("dokkaHtmlMultiModule")
  //documentationFileName.set("README.md")
  outputDirectory.set(file("docs"))
}

