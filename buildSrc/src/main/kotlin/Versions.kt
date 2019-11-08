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
    const val org_jetbrains_kotlinx_kotlinx_coroutines: String = "1.3.2"

    const val org_jetbrains_kotlin: String = "1.3.50"

    const val androidx_test: String = "1.2.0"

    const val com_android_tools_build_gradle: String = "3.5.2"

    const val de_fayard_buildsrcversions_gradle_plugin: String = "0.7.0"

    const val android_maven_gradle_plugin: String = "2.1"

    const val lifecycle_runtime_ktx: String = "2.2.0-rc02"

    const val easypermissions: String = "3.0.0"

    const val lint_gradle: String = "26.5.2"

    const val appcompat: String = "1.1.0"

    const val slf4j_api: String = "1.7.29"

    const val aapt2: String = "3.5.2-5435860"

    /**
     * Current version: "6.0"
     * See issue 19: How to update Gradle itself?
     * https://github.com/jmfayard/buildSrcVersions/issues/19
     */
    const val gradleLatestVersion: String = "6.0"
}

/**
 * See issue #47: how to update buildSrcVersions itself
 * https://github.com/jmfayard/buildSrcVersions/issues/47
 */
val PluginDependenciesSpec.buildSrcVersions: PluginDependencySpec
    inline get() =
            id("de.fayard.buildSrcVersions").version(Versions.de_fayard_buildsrcversions_gradle_plugin)
