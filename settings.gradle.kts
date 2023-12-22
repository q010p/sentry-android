enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "sentry-root"
rootProject.buildFileName = "build.gradle.kts"

include(
    "sentry",
    "sentry-kotlin-extensions",
    "sentry-android-core",
    "sentry-android-ndk",
    "sentry-android",
    "sentry-android-timber",
    "sentry-android-okhttp",
    "sentry-android-fragment",
    "sentry-android-navigation",
    "sentry-android-sqlite",
    "sentry-compose",
    "sentry-compose-helper",
    "sentry-test-support",
    "sentry-okhttp",
    "sentry-samples:sentry-samples-android",
    "sentry-samples:sentry-samples-console",
    "sentry-android-integration-tests:sentry-uitest-android-benchmark",
    "sentry-android-integration-tests:sentry-uitest-android",
    "sentry-android-integration-tests:test-app-plain",
    "sentry-android-integration-tests:test-app-sentry"
)

gradle.beforeProject {
    if (project.name == "sentry-android-ndk" || project.name == "sentry-samples-android") {
        exec {
            logger.log(LogLevel.LIFECYCLE, "Initializing git submodules")
            commandLine("git", "submodule", "update", "--init", "--recursive")
        }
    }
}
