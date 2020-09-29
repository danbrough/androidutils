import org.jetbrains.dokka.gradle.gradleDokkaSourceSetBuilderFactory

plugins {
  id("org.jetbrains.dokka")
}

buildscript {

  dependencies {
    classpath("com.android.tools.build:gradle:4.2.0-alpha12")
    // classpath("com.android.tools.build:gradle:4.1.0-rc03")
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



apply("project.gradle.kts")


allprojects {
  repositories {
    maven("https://maven.pkg.jetbrains.space/kotlin/p/dokka/dev")

    google()
    jcenter()
    maven("https://jitpack.io")
  }

  tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    dokkaSourceSets {
      named("main") { /* configure main source set */
        includes.from(file("README.md"))
        // platform.set(org.jetbrains.dokka.Platform.jvm)
      }
      /*configureEach {
        includes.from("README.md")
      }*/
    }
  }

/*  tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    dokkaSourceSets {
      named("main") { *//* configure main source set *//*
        includes.from(file("README.md"))
        // platform.set(org.jetbrains.dokka.Platform.jvm)
      }
      *//*configureEach {
        includes.from("README.md")
      }*//*
    }
  }*/
}

tasks.dokkaGfmMultiModule {
  println("GFM MULTI MODULE: $this")
  outputDirectory.set(file("docs"))
/*  this.gradleDokkaSourceSetBuilderFactory().create("main").apply {
    includes.from("README.md")
  }*/
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

