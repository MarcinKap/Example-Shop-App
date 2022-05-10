// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        mavenCentral()
        google()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        maven("https://jitpack.io")
        maven("https://android-sdk.voxeet.com/release")
    }



    dependencies {
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.8.1")
        classpath("com.google.gms:google-services:4.3.10")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.LIFECYCLE}")
//        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
        classpath("com.google.android.gms:oss-licenses-plugin:0.10.4")
        classpath("com.squareup:javapoet:1.13.0")
    }

}

plugins {
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.kotlin.android").apply(false)
    id("org.jetbrains.kotlin.kapt").apply(false)
    id("org.jetbrains.kotlin.plugin.parcelize").apply(false)
}

tasks.create<Delete>("clean") {
    group = "build"
    delete(rootProject.buildDir)
}

