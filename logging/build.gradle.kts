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

  sourceSets {

    val commonMain by getting {
    }

    val jvmMain by getting {
    }

    val androidMain by getting {
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
    minSdk = ProjectVersions.MIN_SDK_VERSION
    targetSdk = ProjectVersions.SDK_VERSION
  }
}


