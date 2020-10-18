
plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
  kotlin("android.extensions")
  id("maven-publish")
  id("org.jetbrains.dokka")
}


android {

  compileSdkVersion(ProjectVersions.SDK_VERSION)

  defaultConfig {
    minSdkVersion(ProjectVersions.MIN_SDK_VERSION)
    targetSdkVersion(ProjectVersions.SDK_VERSION)
    versionCode = ProjectVersions.BUILD_VERSION
    versionName = ProjectVersions.VERSION_NAME
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  lintOptions {
    isAbortOnError = false
  }

  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  kotlinOptions {
    jvmTarget = "1.8"
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

val sourcesJar by tasks.registering(Jar::class) {
  archiveClassifier.set("sources")
  from(android.sourceSets.getByName("main").java.srcDirs)
}

afterEvaluate {
  publishing {
    publications {
      val release by publications.registering(MavenPublication::class) {
        from(components["release"])
        artifact(sourcesJar.get())
        artifactId = "menu"
        groupId = ProjectVersions.GROUP_ID
        version = ProjectVersions.VERSION_NAME
      }
    }
  }
}

dependencies {

  implementation(project(":misc"))
  implementation("org.slf4j:slf4j-api:_")
  implementation(AndroidX.appCompat)
  implementation("org.jetbrains.kotlin:kotlin-reflect:_")

  implementation(project(":misc"))
  implementation(AndroidX.recyclerView)
  implementation(AndroidX.constraintLayout)
  implementation(KotlinX.coroutines.android)
  implementation(AndroidX.lifecycle.runtimeKtx)
  implementation(AndroidX.lifecycle.viewModelKtx)
  implementation(AndroidX.lifecycle.liveDataKtx)
  kapt("com.github.bumptech.glide:compiler:_")
  api("com.github.bumptech.glide:glide:_")

  implementation("jp.wasabeef:glide-transformations:_")


  implementation(AndroidX.navigation.fragmentKtx)
  implementation(AndroidX.navigation.uiKtx)

  androidTestImplementation(project(":slf4j"))
  androidTestImplementation(AndroidX.test.rules)
  androidTestImplementation(AndroidX.test.runner)
  androidTestImplementation(AndroidX.test.core)

}

