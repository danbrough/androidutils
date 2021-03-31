import de.fayard.refreshVersions.bootstrapRefreshVersions

buildscript {
  repositories { gradlePluginPortal() }
  dependencies.classpath("de.fayard.refreshVersions:refreshVersions:0.9.7")
}

bootstrapRefreshVersions()


//include ':android_resource',':slf4j', ':touchprompt', ':touchprompt_material',':demo', ':android-ui'
//include( ":resource",":slf4j",":permissions")
//include(":menu2", ":menu2test")
include(":slf4j", ":permissions", ":misc", ":menu", ":logging", ":logging_core")

if (!System.getenv().containsKey("JITPACK") && !System.getenv().containsKey("CI")) {
  include(":demo")
}



rootProject.name = "androidutils"

