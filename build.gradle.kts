buildscript {

  dependencies {
    classpath(Libs.com_android_tools_build_gradle)
    classpath(Libs.kotlin_gradle_plugin)
    //classpath(Libs.navigation_safe_args_gradle_plugin)
    classpath(Libs.android_maven_gradle_plugin)

  }

  repositories {
    google()
    jcenter()
    //    maven { url 'https://dl.bintray.com/kotlin/kotlin-eap' }
    maven {
      url = java.net.URI("https://dl.bintray.com/kotlin/kotlin-eap")
    }
  }
}



plugins {

  //buildSrcVersions
  id("de.fayard.refreshVersions") version "0.7.0"
}

allprojects {
  repositories {
    google()
    jcenter()
    //    maven { url 'https://jitpack.io' }
    maven {
      url = java.net.URI("https://jitpack.io")
    }
    maven {
      url = java.net.URI("https://dl.bintray.com/kotlin/kotlin-eap")
    }
  }

}
