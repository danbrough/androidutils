import org.jetbrains.kotlin.gradle.dsl.copyFreeCompilerArgsToArgs

plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
  id("maven-publish")
  id("org.jetbrains.dokka")
}



android {

  compileSdk = ProjectVersions.SDK_VERSION
  buildToolsVersion = ProjectVersions.BUILD_TOOLS_VERSION

  defaultConfig {
    minSdk = 16
    targetSdk = ProjectVersions.SDK_VERSION
    //versionCode = ProjectVersions.BUILD_VERSION
    //versionName = ProjectVersions.VERSION_NAME
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  buildTypes {

    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(
          getDefaultProguardFile("proguard-android-optimize.txt"),
          "proguard-rules.pro"
      )
    }
  }
}



dependencies {
  api(project(":logging_core"))
}
