plugins {
  id("com.android.library")
  kotlin("android") version "1.6.0"
  //kotlin("kapt")
  id("maven-publish")
  id("org.jetbrains.dokka")
}



android {

  compileSdk = ProjectVersions.SDK_VERSION

  buildToolsVersion = ProjectVersions.BUILD_TOOLS_VERSION

  defaultConfig {
    minSdk = 16
    targetSdk = ProjectVersions.SDK_VERSION
    //versionCode = ProjectVersions.BUILD_VERSION
    //versionName = ProjectVersions.VERSION_NAME
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }


  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }

  buildFeatures {
    compose = true
  }

  composeOptions {
    kotlinCompilerExtensionVersion = ProjectVersions.COMPOSE_VERSION
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
  implementation(AndroidX.core)
  implementation(AndroidX.compose.ui)
}



