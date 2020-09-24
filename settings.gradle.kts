import de.fayard.dependencies.bootstrapRefreshVersionsAndDependencies

buildscript {
  repositories {
    jcenter()
    gradlePluginPortal()
  }
  dependencies.classpath("de.fayard:dependencies:+")
}



bootstrapRefreshVersionsAndDependencies()

//include ':android_resource',':slf4j', ':touchprompt', ':touchprompt_material',':demo', ':android-ui'
//include( ":resource",":slf4j",":permissions")
include(":slf4j", ":permissions", ":misc", ":demo", ":menu")

rootProject.name = "androidutils"

