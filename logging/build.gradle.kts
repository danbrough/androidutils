/*
import com.google.protobuf.gradle.*
import org.gradle.kotlin.dsl.proto
*/

plugins {
  kotlin("jvm")
  `java-library`
  `maven-publish`
  //kotlin("kapt")

  // kotlin("plugin.serialization")
  id("org.jetbrains.dokka")
  // `java-test-fixtures`
  //id("com.google.protobuf")
 // kotlin("plugin.serialization")
}


java {
  sourceCompatibility = ProjectVersions.JAVA_VERSION
  targetCompatibility = ProjectVersions.JAVA_VERSION
}



val sourcesJar by tasks.registering(Jar::class) {
  archiveClassifier.set("sources")
  from(sourceSets.getByName("main").java.srcDirs)
}

group = "danbroid.logging"
version = "0.0.1-alpha01"

publishing {
  publications {
    create<MavenPublication>("default") {
      from(components["java"])
      artifact(sourcesJar)
      this.groupId = "danbroid.logging"
      this.artifactId = "core"
      this.version = "0.0.1-alpha02"
    }
  }
}

