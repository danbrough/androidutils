import org.jetbrains.dokka.gradle.gradleDokkaSourceSetBuilderFactory

plugins {
  id("org.jetbrains.dokka")
}

buildscript {

  val kotlin_version by extra("1.4.10")
  dependencies {
    //classpath("com.android.tools.build:gradle:4.2.0-alpha13")
    classpath("com.android.tools.build:gradle:4.1.0")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
    classpath("org.jetbrains.dokka:dokka-gradle-plugin:_")

    //classpath(AndroidX.navigation.safeArgsGradlePlugin)
  }

  repositories {
    google()
    jcenter()
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
      configureEach {
        includes.from(file("README.md"))
      }
    }
  }

  configurations.all {
    if (name.contains("Test")) {
      resolutionStrategy.dependencySubstitution {
        substitute(project(":slf4j")).with(module("ch.qos.logback:logback-classic:1.2.3"))
      }
    }
    resolutionStrategy.force("org.slf4j:slf4j-api:1.7.30")
  }
}

tasks.dokkaGfmMultiModule {
  outputDirectory.set(file("docs"))
}

