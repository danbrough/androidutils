plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
  kotlin("android.extensions")
}


android {
  compileSdkVersion(ProjectVersions.SDK_VERSION)
  defaultConfig {
    minSdkVersion(16)
    targetSdkVersion(ProjectVersions.SDK_VERSION)
    versionCode = ProjectVersions.VERSION_CODE
    versionName = ProjectVersions.VERSION_NAME
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
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.50")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.2")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-rc02")

  api("pub.devrel:easypermissions:3.0.0")

/*  testImplementation(Libs.junit)
  testImplementation(Libs.androidx_test_core)
  testImplementation(Libs.logback_core)
  testImplementation(Libs.logback_classic)
  testImplementation(Libs.kxml2_min)
  testImplementation(Libs.robolectric)*/

}


