plugins {
    id(Plugins.APP)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_PARCELIZE)
    id(Plugins.KAPT)
    id(Plugins.SAFE_ARGS)
//    id(Plugins.GMS_SERVICES)
//    id(Plugins.CRASHLYTICS)
    id(Plugins.DAGGER_HILT)
}

android {
    packagingOptions {
        jniLibs.pickFirsts.add("lib/arm64-v8a/libc++_shared.so")
        jniLibs.pickFirsts.add("lib/x86_64/libc++_shared.so")
        jniLibs.pickFirsts.add("lib/x86/libc++_shared.so")
        jniLibs.pickFirsts.add("lib/armeabi-v7a/libc++_shared.so")
    }

    compileSdk = Core.COMPILE_SDK

    defaultConfig {
        applicationId ="com.example.exampleshop"
        minSdk = 21
        targetSdk =31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    packagingOptions {
        exclude ("META-INF/gradle/incremental.annotation.processors")
    }

//    packagingOptions {
//        pickFirst ("META-INF/AL2.0")
//        pickFirst ("META-INF/LGPL2.1")
//    }
//    packagingOptions {
//        exclude("META-INF/LICENSE")
//        exclude("META-INF/*.properties")
//        exclude ("META-INF/AL2.0")
//        exclude ("META-INF/LGPL2.1")
//    }

}

kapt {
    correctErrorTypes = true
}

hilt {
    enableAggregatingTask = true
}

dependencies {
//


    implementation(Libs.HILT)
    implementation(Libs.HILT_WORK)
    implementation(Libs.HILT_NAVIGATION)
    implementation("androidx.test.ext:junit-ktx:1.1.3")
    kapt(Libs.HILT_COMPILER_KAPT)
    kapt(Libs.HILT_ANDROIDX_KAPT)

    implementation(Libs.KT_STDLIB)
    implementation(Libs.CORE_KTX)
    implementation(Libs.MATERIAL)
    implementation(Libs.FRAGMENT_KTX)
    implementation(Libs.PREFERENCE)

    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.VIEWPAGER2)
//    implementation(Libs.LIFECYCLE_LIVEDATA_KTX)

    implementation(Libs.JODA)

    implementation(Libs.ADAPTER_DELEGATES)

    implementation(Libs.NAVIGATION_FRAGMENT_KTX)
    implementation(Libs.NAVIGATION_UI_KTX)
    implementation(Libs.TRANSITION)

    implementation(Libs.ROOM_KTX_EXTENSIONS)
    implementation(Libs.ROOM_RUNTIME)
    kapt(Libs.ROOM_KAPT)


    implementation(Libs.TIMBER)
    implementation(Libs.LIFECYCLE_VIEWMODEL)
//    implementation(Libs.LIFECYCLE_LIVEDATA_KTX)
    implementation(Libs.LIFECYCLE_PROCESS)
    kapt(Libs.LIFECYCLE_KAPT)

    implementation(Libs.WORK)
    implementation("androidx.startup:startup-runtime:1.1.0")

//    implementation(Libs.FIREBASE_CRASHLYTICS)
//    implementation(Libs.FIREBASE_MESSAGING)
//    implementation(Libs.FIREBASE_AUTH)
//    implementation(Libs.FIREBASE_CORE)

    implementation(Libs.PLAY_CORE)
    implementation(Libs.AUTOFILL)

    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_GSON)
    implementation(platform(Libs.OKHTTP_BOM))
    implementation(Libs.OKHTTP)

    implementation(Libs.ADAPTER_DELEGATES)
    implementation(Libs.RECYCLER_VIEW)

    //COMPOSE
    implementation(Libs.COMPOSE_MATERIAL)
    implementation(Libs.COMPOSE_ACTIVITY)
    implementation(Libs.COMPOSE_ANIMATION)
    implementation(Libs.COMPOSE_UI_TOOLING)
    implementation(Libs.LIFECYCLE_VIEWMODEL_COMPOSE)
    implementation(Libs.COMPOSE_THEME_ADAPTER)
    implementation(Libs.COMPOSE_PAGER)
    implementation(Libs.COMPOSE_PAGER_INDICATORS)
    implementation(Libs.COMPOSE_CONSTRAINT_LAYOUT)
    implementation(Libs.COMPOSE_RUNTIME)
    implementation(Libs.COMPOSE_RUNTIME_LIVEDATA)
    implementation(Libs.COMPOSE_ICON)
    implementation(Libs.COIL_COMPOSE)
    implementation(Libs.COMPOSE_SWIPE_REFRESH)
    implementation(Libs.COMPOSE_ACCOMPANIST_INSETS)
    implementation(Libs.COMPOSE_ACCOMPANIST_FLOWLAYOUT)
    implementation(Libs.COMPOSE_ACCOMPANIST_PAGER_INDICATOR)

    debugImplementation(Libs.COMPOSE_TEST_MANIFEST)
    debugImplementation(Libs.COMPOSE_JUNIT_TEST)
    testImplementation(TestDependencies.TRUTH)
    testImplementation(TestDependencies.MOCKITO)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1")
    androidTestImplementation(Libs.ROOM_TESTING)
    androidTestImplementation(AndroidTestDependencies.JUNIT)
    androidTestImplementation(AndroidTestDependencies.ESPRESSO)
    // For instrumentation tests
    androidTestImplementation(AndroidTestDependencies.DAGGER_HILT)
    androidTestImplementation(AndroidTestDependencies.MOCKITO)

    testImplementation("junit:junit:4.13.2")


    implementation("com.google.dagger:hilt-android-compiler:${Versions.HILT}")
}