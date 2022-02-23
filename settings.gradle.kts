plugins {
  id("de.fayard.refreshVersions") version "0.40.1"
}


//include(":misc", ":menu",  ":permissions", ":logging")

//include(":compose")
include(":logging",":compose",":misc")

if (!System.getenv().containsKey("JITPACK") && !System.getenv().containsKey("CI")) {
  // include(":demo")
}



rootProject.name = "androidutils"

