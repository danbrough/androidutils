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
    minSdk = 21
    targetSdk = ProjectVersions.SDK_VERSION
    //versionCode = ProjectVersions.BUILD_VERSION
    //versionName = ProjectVersions.VERSION_NAME
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  lint {
    isAbortOnError = false
  }

  buildFeatures {
    viewBinding = true
  }

  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  kotlinOptions {
    jvmTarget = "1.8"
    //freeCompilerArgs = listOf("-Xjsr305=strict")

    freeCompilerArgs = mutableListOf("-Xopt-in=kotlin.ExperimentalStdlibApi").also {
      it.addAll(freeCompilerArgs)
    }

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

/*val sourcesJar by tasks.registering(Jar::class) {
  archiveClassifier.set("sources")
  from(android.sourceSets.getByName("main").java.srcDirs)
}

afterEvaluate {
  publishing {
    publications {
      val release by registering(MavenPublication::class) {
        from(components["release"])
        artifact(sourcesJar.get())
        artifactId = "menu"
        groupId = ProjectVersions.GROUP_ID
        version = ProjectVersions.VERSION_NAME
      }
    }
  }
}*/

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
  api("com.mikepenz:iconics-core:_")


  api(AndroidX.navigation.fragmentKtx)
  api(AndroidX.navigation.uiKtx)

  androidTestImplementation(project(":slf4j"))
  androidTestImplementation(AndroidX.test.rules)
  androidTestImplementation(AndroidX.test.runner)
  androidTestImplementation(AndroidX.test.core)

  testImplementation(Testing.junit4)

}

