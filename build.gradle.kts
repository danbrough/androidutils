plugins {
  id("org.jetbrains.dokka")
}

buildscript {

  dependencies {
    classpath("com.android.tools.build:gradle:4.2.0-alpha12")
    //classpath("com.android.tools.build:gradle:4.1.0-rc03")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
    classpath("org.jetbrains.dokka:dokka-gradle-plugin:_")


    classpath(AndroidX.navigation.safeArgsGradlePlugin)
  }

  repositories {
    google()
    jcenter()
    mavenCentral()

  }
}


/*tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
  dokkaSourceSets {
    named("main") {
      println("PROCESSING MAIUN")
      includes.from("README.md")
    }
  }
}*/

/*tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
  this.outputDirectory.set(file("docs"))
*//*  dokkaSourceSets {
    named("main") {

      displayName.set("Dokka Gradle Example")
      includes.from("README.md")
      *//**//*this.so
      sourceLink {
        localDirectory.set(file("src/main/java"))
        *//**//**//**//*remoteUrl.set(URL("https://github.com/Kotlin/kotlin-examples/tree/master/" +
            "gradle/dokka/dokka-gradle-example/src/main/kotlin"
        ))*//**//**//**//*
        remoteLineSuffix.set("#L")
      }*//**//*
    }
  }*//*
}*/
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
    maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")

    google()
    jcenter()
    maven("https://jitpack.io")
  }
}

subprojects {
  tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    println("CONFIGURING $this")
    dokkaSourceSets {
      configureEach {
        println("SOURCE SET: $this ${this.name}")
        if (name == "main") {
          println("FOUND MAIN SOURCE SEt includes: $includes")
          includes.from(file("README.md"))
          includes.forEach {
            println("INCLUDE: $it")
          }

         // includes.from("README.md")
        }
        //this.includes.from("README.md")
      }
    }
  }

}

/*

tasks.dokkaGfmMultiModule {
  println("GFM MULTI MODULE: $this")
  outputDirectory.set(file("docs"))
  this.gradleDokkaSourceSetBuilderFactory().create("main").apply {
    includes.from("README.md")
  }
}
*/


//tasks.dokkaHtmlMultiModule {
//  println("dokkaHtmlMultiModule")
//  //documentationFileName.set("README.md")
//  outputDirectory.set(file("docs"))
//}

