import kotlin.String

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
    const val org_jetbrains_kotlin: String = "1.3.50"

    const val androidx_test: String = "1.2.0"

    const val com_android_tools_build_gradle: String = "3.5.1"

    const val de_fayard_refreshversions_gradle_plugin: String = "0.7.0" // available: "0.8.1"

    const val android_maven_gradle_plugin: String = "2.1"

    const val lint_gradle: String = "26.5.1"

    const val appcompat: String = "1.1.0"

    const val slf4j_api: String = "1.7.28"

    const val aapt2: String = "3.5.1-5435860"

    /**
     * Current version: "5.6.3"
     * See issue 19: How to update Gradle itself?
     * https://github.com/jmfayard/buildSrcVersions/issues/19
     */
    const val gradleLatestVersion: String = "5.6.3"
}
