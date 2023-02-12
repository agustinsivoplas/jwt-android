import Dependencies.Compose.composeBom
import Dependencies.Compose.composeFoundation
import Dependencies.Compose.composeMaterial3
import Dependencies.Compose.composeToolingPreview
import Dependencies.Compose.composeUI
import Dependencies.Test.composeTooling
import Dependencies.Test.composeUITestJunit4
import Dependencies.Test.composeUITestManifest
import Dependencies.Test.espressoCore
import Dependencies.Test.extJUnit
import Dependencies.UI.activityCompose
import Dependencies.UI.appcompat
import Dependencies.UI.constraintLayout
import Dependencies.UI.coreKtx
import Dependencies.UI.lifecycleRuntimeKtx
import org.gradle.api.artifacts.dsl.DependencyHandler

object AppConfig {
    const val applicationId = "com.skybluelabs.jwt"
    const val compileSdk = 33
    const val minSdk = 26
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    //app level
    const val androidGradlePluginVersion = "7.4.1"
    const val kotlinGradlePluginVersion = "1.8.0"
    const val kotlinVersion = "1.8.0"
    const val kotlinCompilerExtensionVersion = "1.4.0"
    const val composeBomVersion = "2023.01.00"

    //libs
    const val coreKtxVersion = "1.7.0"
    const val appcompatVersion = "1.7.0-alpha02"
    const val constraintLayoutVersion = "2.2.0-alpha07"
    const val lifecycleRuntimeKtxVersion = "2.6.0-beta01"
    const val activityComposeVersion = "1.7.0-beta01"

    //test
    const val junitVersion = "4.13.2"
    const val extJunitVersion = "1.1.5"
    const val espressoVersion = "3.5.1"
}

object Dependencies {

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"

    object UI {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtxVersion}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    }

    object Compose {
        const val composeBom = "androidx.compose:compose-bom:${Versions.composeBomVersion}"
        const val composeFoundation = "androidx.compose.foundation:foundation"
        const val composeUI = "androidx.compose.ui:ui"
        const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeMaterial3 = "androidx.compose.material3:material3"
    }

    object Test {
        const val composeTooling = "androidx.compose.ui:ui-tooling"
        const val composeUITestManifest = "androidx.compose.ui:ui-test-manifest"
        const val composeUITestJunit4 = "androidx.compose.ui:ui-test-junit4"

        const val junit = "junit:junit:${Versions.junitVersion}"
        const val extJUnit = "androidx.test.ext:junit:${Versions.extJunitVersion}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    }

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(lifecycleRuntimeKtx)
        add(activityCompose)

        add(composeFoundation)
        add(composeUI)
        add(composeToolingPreview)
        add(composeMaterial3)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(Test.junit)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(composeUITestJunit4)
    }

    val debugImplementationLibraries = arrayListOf<String>().apply {
        add(composeTooling)
        add(composeUITestManifest)
    }
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"

    object Kotlin {
        const val kapt = "kapt"
        const val android = "android"

        const val jetbrainsAndroid = "org.jetbrains.kotlin.android"
        const val jetbrainsJVM = "org.jetbrains.kotlin.jvm"
    }
}


//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}