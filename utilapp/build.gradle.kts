plugins {
  id("com.android.application")
  id("kotlin-android")
}

android {
  compileSdk = ProjectVersions.SDK_VERSION
  buildToolsVersion = ProjectVersions.BUILD_TOOLS_VERSION

  defaultConfig {
    minSdk = 21
    targetSdk = ProjectVersions.SDK_VERSION
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }

  compileOptions {
    sourceCompatibility = ProjectVersions.JAVA_VERSION
    targetCompatibility = ProjectVersions.JAVA_VERSION
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  buildFeatures {
    viewBinding = true
  }
}

dependencies {

  implementation(project(":logging_android"))
  implementation(project(":menu"))
  implementation(project(":misc"))

  implementation("androidx.core:core-ktx:_")
  implementation("androidx.appcompat:appcompat:_")
  implementation("com.google.android.material:material:_")

  testImplementation("junit:junit:_")
  androidTestImplementation("androidx.test.ext:junit:_")
  androidTestImplementation("androidx.test.espresso:espresso-core:_")
}