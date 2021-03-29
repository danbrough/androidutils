plugins {
  id("com.android.library")
  kotlin("android")
  //kotlin("kapt")
  id("maven-publish")
  id("org.jetbrains.dokka")
}



android {

  compileSdkVersion(ProjectVersions.SDK_VERSION)
  defaultConfig {
    minSdkVersion(16)
    targetSdkVersion(ProjectVersions.SDK_VERSION)
    versionCode = ProjectVersions.BUILD_VERSION
    versionName = ProjectVersions.VERSION_NAME
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  lint {
    isAbortOnError = false
  }

  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = mutableListOf("-Xopt-in=kotlin.ExperimentalStdlibApi").also {
      it.addAll(freeCompilerArgs)
    }
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


}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-reflect:_")
  implementation(AndroidX.core)

}



