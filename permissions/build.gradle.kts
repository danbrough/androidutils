plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
  kotlin("android.extensions")
  id("com.github.dcendents.android-maven")
}

group = "com.github.danbrough.util"

android {
  compileSdkVersion(ProjectVersions.SDK_VERSION)
  defaultConfig {
    minSdkVersion(16)
    targetSdkVersion(ProjectVersions.SDK_VERSION)
    versionCode = 1
    versionName = "0.0.1"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")

/*
    javaCompileOptions {
      annotationProcessorOptions {
        argument("room.schemaLocation", "$projectDir/schemas")
        argument("room.incremental", "true")
        argument("room.expandProjection", "true")
      }
    }
*/

  }

  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  buildTypes {

    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
    }

  }

  androidExtensions {
    isExperimental = true
  }

  testOptions {
    unitTests.setReturnDefaultValues(true)
  }

  sourceSets {
    maybeCreate("main").java.srcDir("../jvm_src/domain")
  }
}

kotlin.sourceSets.all {
  languageSettings.useExperimentalAnnotation("kotlin.Experimental")
}


dependencies {
  /* api(project(":common_domain")) {
     exclude(group = "com.android", module = "android")
   }*/

  implementation(Libs.slf4j_api)
  implementation(Libs.kotlin_stdlib_jdk8)
  implementation(Libs.kotlinx_coroutines_android)
  implementation(Libs.lifecycle_runtime_ktx)

  api(Libs.easypermissions)

/*  testImplementation(Libs.junit)
  testImplementation(Libs.androidx_test_core)
  testImplementation(Libs.logback_core)
  testImplementation(Libs.logback_classic)
  testImplementation(Libs.kxml2_min)
  testImplementation(Libs.robolectric)*/

}


