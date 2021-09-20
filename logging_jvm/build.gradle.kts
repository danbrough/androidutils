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

sourceSets.main {
  java.srcDirs("src/main/java", "../logging_core/src/main/java")
}


java {
  sourceCompatibility = ProjectVersions.JAVA_VERSION
  targetCompatibility = ProjectVersions.JAVA_VERSION
}




tasks.withType<Test> {
  useJUnit()
  testLogging {
    events("standardOut", "started", "passed", "skipped", "failed")
    showStandardStreams = true
    outputs.upToDateWhen {
      false
    }
  }
}


val sourcesJar by tasks.registering(Jar::class) {
  archiveClassifier.set("sources")
  from(sourceSets.getByName("main").java.srcDirs)
}

group = ProjectVersions.GROUP_ID
version = ProjectVersions.getVersionName()

publishing {
  publications {
    create<MavenPublication>("default") {
      from(components["java"])
      artifact(sourcesJar)
    }
  }
}


dependencies {
  // implementation("net.jcip:jcip-annotations:1.0")

  //api(project(":logging_core"))
  testImplementation(Kotlin.Test.junit)
}


