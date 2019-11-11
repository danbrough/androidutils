plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  kotlin("android.extensions")
}


android {

  compileSdkVersion(ProjectVersions.SDK_VERSION)

  defaultConfig {
    minSdkVersion(ProjectVersions.MIN_SDK_VERSION)
    targetSdkVersion(ProjectVersions.SDK_VERSION)
    versionCode = ProjectVersions.VERSION_CODE
    versionName = ProjectVersions.VERSION_NAME
    multiDexEnabled = true
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }


  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  dataBinding {
    isEnabled = false
  }

  androidExtensions {
    isExperimental = true
  }


/*  signingConfigs {
    register("release") {
      storeFile = File("/home/dan/.android/nzrp_keystore2")
      keyAlias = "nzrp"
      storePassword = KeystoreConfig.KEYSTORE_PASSWORD
      keyPassword = KeystoreConfig.KEYSTORE_PASSWORD
    }
  }*/

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
      //      signingConfig signingConfigs.release
      // signingConfig = signingConfigs.getByName("release")
    }
  }

  testOptions {
    unitTests.isIncludeAndroidResources = true
    unitTests.isReturnDefaultValues = true
  }

  sourceSets {
    getByName("main").java.srcDir("../jvm_src/rnz")
  }

  kotlin {
    sourceSets {
      all {
        languageSettings.useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
        languageSettings.useExperimentalAnnotation("kotlinx.coroutines.FlowPreview")
      }
    }
  }
}




dependencies {
  implementation(project(":permissions"))

  implementation(Libs.slf4j)
  implementation(Libs.kotlinx_coroutines_android)

  implementation(Libs.lifecycle_extensions)
  implementation(Libs.lifecycle_runtime_ktx)
  implementation(Libs.core_ktx)
  implementation(Libs.lifecycle_viewmodel_ktx)
  implementation(Libs.fragment_ktx)

}

tasks.withType<Test> {
  useJUnit()
  testLogging {
    events("standardOut", "started", "passed", "skipped", "failed")
    showStandardStreams = true
    outputs.upToDateWhen {
      false
    }
  }
}

