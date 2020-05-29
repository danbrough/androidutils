plugins {
  id("com.android.library")
  id("digital.wup.android-maven-publish")
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

/*  flavorDimensions("stuff")

  productFlavors {

    create("stdout") {
      setDimension("stuff")
    }
   // println("PRODUCT FLAVOURS: ${asMap}")

  }*/


  publishing {
    publications {

      create<MavenPublication>("mavenAar") {
        groupId = ProjectVersions.GROUP_ID
        artifactId = "slf4j"
        version = ProjectVersions.VERSION_NAME
        from(components["android"])
        artifact(sourcesJar.get())

      }
    }
  }
}

dependencies {
  implementation( "org.slf4j:slf4j-api:_")
  //api(Libs.appcompat)

  androidTestImplementation(AndroidX.test.core)
  androidTestImplementation(AndroidX.test.runner)
  androidTestImplementation(AndroidX.test.rules)

}

