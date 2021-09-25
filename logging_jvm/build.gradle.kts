/*
import com.google.protobuf.gradle.*
import org.gradle.kotlin.dsl.proto
*/

plugins {
  kotlin("jvm")
  `java-library`
  `maven-publish`
  id("org.jetbrains.dokka")
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
  api(project(":logging_core"))
  implementation(project(mapOf("path" to ":logging_core")))
  testImplementation(Kotlin.Test.junit)
}


