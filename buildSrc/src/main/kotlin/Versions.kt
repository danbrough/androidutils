import kotlin.String
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Generated by https://github.com/jmfayard/buildSrcVersions
 *
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version.
 */
object Versions {
    const val org_jetbrains_kotlinx_kotlinx_coroutines: String = "1.3.5"
             // available: "1.3.5-1.4-M1-release-99"

    const val org_jetbrains_kotlin: String = "1.3.72"

    const val androidx_lifecycle: String = "2.2.0"

    const val androidx_multidex: String = "2.0.0"

    const val androidx_test: String = "1.2.0"

    const val com_android_tools_build_gradle: String = "4.0.0-beta04"

    const val digital_wup_android_maven_publish_gradle_plugin: String = "3.6.3"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.7.0"

    const val org_jetbrains_dokka_gradle_plugin: String = "0.10.1"

    const val easypermissions: String = "3.0.0"

    const val fragment_ktx: String = "1.2.4"

    const val recyclerview: String = "1.1.0"

    const val lint_gradle: String = "27.0.0-beta04"

    const val appcompat: String = "1.1.0"

    const val slf4j_api: String = "1.7.30"

    const val core_ktx: String = "1.2.0"

    const val material: String = "1.1.0"

    const val aapt2: String = "4.0.0-beta04-6051327"

    /**
     * Current version: "6.3"
     * See issue 19: How to update Gradle itself?
     * https://github.com/jmfayard/buildSrcVersions/issues/19
     */
    const val gradleLatestVersion: String = "6.3"
}

/**
 * See issue #47: how to update buildSrcVersions itself
 * https://github.com/jmfayard/buildSrcVersions/issues/47
 */
val PluginDependenciesSpec.buildSrcVersions: PluginDependencySpec
    inline get() =
            id("de.fayard.buildSrcVersions").version(Versions.de_fayard_buildsrcversions_gradle_plugin)
