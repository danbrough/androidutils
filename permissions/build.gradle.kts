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
    minSdk = ProjectVersions.MIN_SDK_VERSION
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
  testOptions {
    //unitTests.setReturnDefaultValues(true)
  }

}

/*val sourcesJar by tasks.registering(Jar::class) {
  archiveClassifier.set("sources")
  from(android.sourceSets.getByName("main").java.srcDirs)
}

afterEvaluate {
  publishing {
    publications {
      val release by publications.registering(MavenPublication::class) {
        from(components["release"])
        artifact(sourcesJar.get())
        artifactId = "permissions"
        groupId = ProjectVersions.GROUP_ID
        version = ProjectVersions.VERSION_NAME
      }
    }
  }
}*/

/*
tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
  dokkaSourceSets {
    configureEach {
      this.platform.set(org.jetbrains.dokka.Platform.jvm)
      includes.from("README.md")
    }
  }
}
*/



dependencies {


  implementation(project(":logging"))
  implementation(Kotlin.stdlib.jdk8)
  implementation(KotlinX.coroutines.android)
  implementation(AndroidX.lifecycle.runtimeKtx)

  api("pub.devrel:easypermissions:_")


}


