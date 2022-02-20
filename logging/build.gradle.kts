plugins {
  kotlin("multiplatform")
  // id("com.android.library")
  `maven-publish`
}

group = ProjectVersions.GROUP_ID
version = ProjectVersions.VERSION_NAME

kotlin {
/*
  android {
    publishLibraryVariants("release")
  }*/


  jvm {
    withJava()

    compilations.all {
      kotlinOptions.jvmTarget = ProjectVersions.KOTLIN_JVM_VERSION
    }
  }


  androidNativeX86()
  androidNativeArm64()
  androidNativeArm32()
  androidNativeX64()


  linuxX64()

  linuxArm64()

  linuxArm32Hfp()

  mingwX64()
  mingwX86()




  sourceSets {

    commonMain {
    }

    val jvmMain by getting {
      // dependsOn(commonMain.get())
    }

/*    val androidMain by getting {
      //   dependsOn(commonMain.get())
    }*/

    val nativeMain by creating {
      // dependsOn(commonMain.get())
    }

    val linuxX64Main by getting {
      dependsOn(nativeMain)
    }

    val linuxArm64Main by getting {
      dependsOn(nativeMain)
    }
    val linuxArm32HfpMain by getting {
      dependsOn(nativeMain)
    }

    val mingwX86Main by getting {
      dependsOn(nativeMain)
    }

    val mingwX64Main by getting {
      dependsOn(nativeMain)
    }

    val androidNativeArm64Main by getting {
      dependsOn(nativeMain)
    }
    val androidNativeArm32Main by getting {
      dependsOn(nativeMain)
    }

    val androidNativeX86Main by getting {
      dependsOn(nativeMain)
    }

    val androidNativeX64Main by getting {
      dependsOn(nativeMain)
    }


/*    val android386Main by getting {
      dependsOn(nativeMain)
    }*/
  }

/*
  val publicationsFromMainHost =
      listOf(jvm(), android()).map { it.name } + "kotlinMultiplatform"

  publishing {
    publications {
      matching { it.name in publicationsFromMainHost }.all {
        val targetPublication = this@all
        tasks.withType<AbstractPublishToMaven>()
            .matching { it.publication == targetPublication }
            .configureEach { onlyIf { true } }
        //.configureEach { onlyIf { findProperty("isMainHost") == "true" } }
      }
    }
  }*/
}


publishing {

/*  publications {
    kotlin.targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class) {
      binaries.matching { it is org.jetbrains.kotlin.gradle.plugin.mpp.SharedLibrary }.all {

        val publicationName =
            "${baseName}${
              buildType.toString().toLowerCase().capitalize()
            }${target.name.capitalize()}"

        val jarTask = tasks.create("${publicationName}Jar", Jar::class) {
          from(linkTask.outputs.files)
          dependsOn(linkTask)
        }

        create<MavenPublication>(publicationName) {
          artifactId = publicationName
          artifact(jarTask)
        }
      }
    }
  }*/

  repositories {
    maven(ProjectVersions.MAVEN_REPO)
  }
}


/*
android {
  compileSdk = ProjectVersions.SDK_VERSION
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

  defaultConfig {
    minSdk = 16
    targetSdk = ProjectVersions.SDK_VERSION
  }
}


*/

