plugins {
  kotlin("multiplatform")
  id("com.android.library")
  `maven-publish`
}

group = ProjectVersions.GROUP_ID
version = ProjectVersions.VERSION_NAME

kotlin {

  android {
    publishLibraryVariants("release")
  }


  jvm {
    compilations.all {
      kotlinOptions.jvmTarget = ProjectVersions.KOTLIN_JVM_VERSION
    }
  }


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

    val androidMain by getting {
      //   dependsOn(commonMain.get())
    }

    val nativeMain by creating {
      // dependsOn(commonMain.get())
    }

    val linuxX64Main by getting {
      dependsOn(nativeMain)
    }

    val linuxArm64Main by getting{
      dependsOn(nativeMain)
    }
    val linuxArm32HfpMain by getting{
      dependsOn(nativeMain)
    }

    val mingwX86Main by getting {
      dependsOn(nativeMain)
    }

    val mingwX64Main by getting {
      dependsOn(nativeMain)
    }
  }


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
  }
}

android {
  compileSdk = ProjectVersions.SDK_VERSION
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

  defaultConfig {
    minSdk = 16
    targetSdk = ProjectVersions.SDK_VERSION
  }
}



