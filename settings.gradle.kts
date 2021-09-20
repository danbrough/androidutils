plugins {
  id("de.fayard.refreshVersions") version "0.21.0"
}

//include ':android_resource',':slf4j', ':touchprompt', ':touchprompt_material',':demo', ':android-ui'
//include( ":resource",":slf4j",":permissions")
//include(":menu2", ":menu2test")
include(":misc", ":menu",  ":permissions", ":logging_core", ":logging_jvm",":logging_android",
    ":logging_from_slf4j", ":logging_to_slf4j", ":compose")

if (!System.getenv().containsKey("JITPACK") && !System.getenv().containsKey("CI")) {
 // include(":demo")
}



rootProject.name = "androidutils"

