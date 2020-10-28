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

  lintOptions {
    isAbortOnError = false
  }

  testOptions {
    unitTests.isIncludeAndroidResources = true
    unitTests.isReturnDefaultValues = true
  }


/*  configurations.all {
    println("CONF: $this")
    forEach {
      println("FOR EACH $it")
    }
  }*/

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




dependencies {

  implementation(project(":menu"))

  implementation("org.slf4j:slf4j-api:_")


  testImplementation(Testing.junit4)
  testImplementation("ch.qos.logback:logback-core:_")
  testImplementation("ch.qos.logback:logback-classic:_")
  //testImplementation("org.mockito:mockito-core:2.28.2")

//  implementation("com.mikepenz:iconics-core:_")
  implementation(AndroidX.appCompat)

  implementation("com.mikepenz:fontawesome-typeface:_")
  implementation("com.mikepenz:google-material-typeface:_")
  implementation("com.mikepenz:iconics-core:_")

 // implementation("org.jetbrains.kotlin:kotlin-reflect:_")
  //implementation("com.mikepenz:material-design-iconic-typeface:2.2.0.7-kotlin")
  //implementation("com.mikepenz:fontawesome-typeface:5.9.0.1-kotlin@aar")
  //implementation("com.mikepenz:google-material-typeface:3.0.1.5.original-kotlin@aar")

  implementation(project(":permissions"))
  // or implementation("com.github.danbrough.androidutils:permissions:master-SNAPSHOT")

  implementation(project(":slf4j"))
  // or implementation("com.github.danbrough.androidutils:slf4j:master-SNAPSHOT")

  implementation(project(":misc"))
  // or implementation("com.github.danbrough.androidutils:misc:master-SNAPSHOT")
  implementation(Google.android.material)

  implementation(AndroidX.preferenceKtx)

  //implementation(AndroidX.activityKtx)
  implementation(AndroidX.coreKtx)
  implementation(AndroidX.coordinatorLayout)

  implementation(AndroidX.fragmentKtx)

  //implementation(AndroidX.lifecycle.extensions)
  implementation(AndroidX.lifecycle.liveDataCoreKtx)
  implementation(AndroidX.lifecycle.liveDataKtx)
  implementation(AndroidX.lifecycle.viewModelKtx)
  implementation(AndroidX.lifecycle.runtimeKtx)
  implementation(AndroidX.navigation.fragmentKtx)
  implementation(AndroidX.navigation.uiKtx)
  implementation(AndroidX.recyclerView)


}


