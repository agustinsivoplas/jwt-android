buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.androidGradlePluginVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePluginVersion}")
    }

    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id(Plugins.androidApplication) version Versions.androidGradlePluginVersion apply false
    id(Plugins.androidLibrary) version Versions.androidGradlePluginVersion apply false
    id(Plugins.Kotlin.jetbrainsAndroid) version Versions.kotlinVersion apply false
    id(Plugins.Kotlin.jetbrainsJVM) version Versions.kotlinVersion apply false
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}