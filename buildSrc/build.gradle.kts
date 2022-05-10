import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    kotlin("jvm") version "1.7.0-Beta"
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://android-sdk.voxeet.com/release")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.android.tools.build:gradle:7.0.4")
    implementation("com.android.tools.build:gradle-api:7.0.4")
    implementation("com.squareup:javapoet:1.13.0")
    gradleApi()
    implementation(kotlin("stdlib-jdk8"))
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}