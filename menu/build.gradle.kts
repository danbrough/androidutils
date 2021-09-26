plugins {
  id("com.android.library")
  kotlin("android")
  kotlin("kapt")
  kotlin("plugin.serialization")
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

  buildFeatures {
    viewBinding = false
  }

  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = ProjectVersions.COMPOSE_VERSION
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

  val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").java.srcDirs)
  }

  afterEvaluate {

    publishing {
      publications {
        val release by registering(MavenPublication::class) {
          from(components["release"])
          artifact(sourcesJar.get())
          artifactId = project.name
          groupId = ProjectVersions.GROUP_ID
          version = ProjectVersions.VERSION_NAME
        }
      }
    }
  }
}



dependencies {


  implementation("org.jetbrains.kotlin:kotlin-reflect:_")
  implementation(KotlinX.serialization.json)
  implementation("com.github.danbrough.androidutils:misc:_")
  implementation(project(":logging"))
  //implementation("com.github.danbrough.androidutils:logging-android:_")
  implementation(COIL)
  implementation(COIL.compose)
  implementation(AndroidX.compose.runtime)
  implementation(AndroidX.compose.material)
  implementation(AndroidX.compose.foundation)
  implementation(AndroidX.compose.ui.tooling)
  implementation(AndroidX.constraintLayoutCompose)

  implementation(AndroidX.navigation.compose)
  implementation(AndroidX.activity.compose)
  implementation(AndroidX.lifecycle.viewModelCompose)
  implementation(AndroidX.compose.material.icons.extended)
}

