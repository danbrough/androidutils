plugins {
    id("de.fayard.refreshVersions") version "0.10.0"
}

//include ':android_resource',':slf4j', ':touchprompt', ':touchprompt_material',':demo', ':android-ui'
//include( ":resource",":slf4j",":permissions")
//include(":menu2", ":menu2test")
include(":slf4j", ":permissions", ":misc", ":menu", ":logging", ":logging_core",":compose")

if (!System.getenv().containsKey("JITPACK") && !System.getenv().containsKey("CI")) {
  include(":demo")
}



rootProject.name = "androidutils"

