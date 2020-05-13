plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  kotlin("android.extensions")
  id("androidx.navigation.safeargs.kotlin")
  id("digital.wup.android-maven-publish") version Versions.digital_wup_android_maven_publish_gradle_plugin
  id("org.jetbrains.dokka")

}


android {

  compileSdkVersion(ProjectVersions.SDK_VERSION)

  defaultConfig {
    minSdkVersion(ProjectVersions.MIN_SDK_VERSION)
    targetSdkVersion(ProjectVersions.SDK_VERSION)
    versionCode = ProjectVersions.BUILD_VERSION
    versionName = ProjectVersions.VERSION_NAME
    multiDexEnabled = true
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }


  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  buildFeatures {
    dataBinding = false
  }

  androidExtensions {
    isExperimental = true
  }

  kotlinOptions {
    jvmTarget = "1.8"
    //freeCompilerArgs = listOf("-Xjsr305=strict")
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

  testOptions {
    unitTests.isIncludeAndroidResources = true
    unitTests.isReturnDefaultValues = true
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
  implementation(project(":menu"))
  // or implementation("com.github.danbrough.androidutils:content:master-SNAPSHOT")

  implementation(project(":permissions"))
  // or implementation("com.github.danbrough.androidutils:permissions:master-SNAPSHOT")

  implementation(project(":slf4j"))
  // or implementation("com.github.danbrough.androidutils:slf4j:master-SNAPSHOT")

  implementation(project(":misc"))
  // or implementation("com.github.danbrough.androidutils:resource:master-SNAPSHOT")
  implementation(Libs.material)

  implementation(Libs.lifecycle_extensions)
  implementation(Libs.lifecycle_runtime_ktx)
  implementation(Libs.core_ktx)
  implementation(Libs.lifecycle_viewmodel_ktx)
  implementation(Libs.fragment_ktx)
  implementation(Libs.recyclerview)
  implementation("androidx.navigation:navigation-fragment-ktx:2.3.0-alpha06")
  implementation("androidx.navigation:navigation-ui-ktx:2.3.0-alpha06")

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

