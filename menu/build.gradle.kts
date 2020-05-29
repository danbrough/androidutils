plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
  kotlin("android.extensions")
  id("androidx.navigation.safeargs.kotlin")

  id("kotlin-android")
  id("kotlin-android-extensions")

  id("digital.wup.android-maven-publish")
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

  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  androidExtensions {
    isExperimental = true
  }

  kotlinOptions {
    jvmTarget = "1.8"
    //freeCompilerArgs = listOf("-Xjsr305=strict")
  }



  kotlin.sourceSets.all {
    setOf(
        "kotlinx.coroutines.ExperimentalCoroutinesApi",
        "kotlinx.coroutines.FlowPreview"
    ).forEach {
      languageSettings.useExperimentalAnnotation(it)
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

  val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
  }

  publishing {
    publications {

      create<MavenPublication>("mavenAar") {
        groupId = ProjectVersions.GROUP_ID

        artifactId = "menu"
        version = ProjectVersions.VERSION_NAME
        from(components["android"])
        artifact(sourcesJar.get())

      }
    }
  }
}

dependencies {

  implementation("org.slf4j:slf4j-api:_")
  implementation(AndroidX.appCompat)
  implementation("org.jetbrains.kotlin:kotlin-reflect:_")
  implementation(project(":misc"))
  implementation(AndroidX.recyclerView)
  implementation(AndroidX.constraintLayout)
  implementation(KotlinX.coroutines.android)
  implementation(AndroidX.lifecycle.runtimeKtx)
  implementation(AndroidX.lifecycle.viewModelKtx)
  implementation(AndroidX.lifecycle.extensions)
  implementation(AndroidX.lifecycle.liveDataKtx)



  implementation(AndroidX.navigation.fragmentKtx)
  implementation(AndroidX.navigation.uiKtx)

  androidTestImplementation(project(":slf4j"))
  androidTestImplementation(AndroidX.test.rules)
  androidTestImplementation(AndroidX.test.runner)
  androidTestImplementation(AndroidX.test.core)

}


/*
  implementation "androidx.room:room-runtime:$room_version"
  kapt "androidx.room:room-compiler:$room_version" // For Kotlin use kapt instead of annotationProcessor

  // optional - Kotlin Extensions and Coroutines support for Room
  api "androidx.room:room-ktx:$room_version"
*//*



  implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
  implementation 'androidx.core:core-ktx:1.1.0'
  testImplementation 'junit:junit:4.12'
  androidTestImplementation 'androidx.test.ext:junit:1.1.1'
  androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}

/*
apply plugin: 'com.android.library'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt'

apply plugin: 'com.github.dcendents.android-maven'
group = 'com.github.danbroid.util'

android {
  compileSdkVersion sdk_version


  defaultConfig {
    minSdkVersion 15
    targetSdkVersion sdk_version
    versionCode 1
    versionName 'resource-0.0.2'

    testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles 'consumer-rules.pro'

    javaCompileOptions {
      annotationProcessorOptions {
        arguments = [
            "room.schemaLocation"  : "$projectDir/schemas".toString(),
            "room.incremental"     : "true",
            "room.expandProjection": "true"]
      }
    }

  }

  buildTypes {
    release {
      minifyEnabled false
      proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
    }
  }

  compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  task sourcesJar(type: Jar) {
    from android.sourceSets.main.java.srcDirs
    classifier = 'sources'
  }

  artifacts {
    archives sourcesJar
  }

}

dependencies {

  api "org.slf4j:slf4j-api:$slf4j_version"
  api "androidx.appcompat:appcompat:$app_compat_version"

*/
/*
  implementation "androidx.room:room-runtime:$room_version"
  kapt "androidx.room:room-compiler:$room_version" // For Kotlin use kapt instead of annotationProcessor

  // optional - Kotlin Extensions and Coroutines support for Room
  api "androidx.room:room-ktx:$room_version"
*//*



  implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
  implementation 'androidx.core:core-ktx:1.1.0'
  testImplementation 'junit:junit:4.12'
  androidTestImplementation 'androidx.test.ext:junit:1.1.1'
  androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}
*/

