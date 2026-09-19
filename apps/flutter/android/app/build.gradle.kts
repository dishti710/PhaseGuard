plugins {
    id("com.android.application")
<<<<<<< HEAD
=======
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
>>>>>>> dishti/feature/android-compose-ui
    id("dev.flutter.flutter-gradle-plugin")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.phaseguard.phaseguard"
<<<<<<< HEAD
    compileSdk = flutter.compileSdkVersion
    // Explicitly set NDK 27 — required for llama_cpp_dart CMake native build
    ndkVersion = "27.0.12077973"
=======
    compileSdk = 36  // Required for Agora and Firebase plugins
    ndkVersion = flutter.ndkVersion
>>>>>>> dishti/feature/android-compose-ui

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        isCoreLibraryDesugaringEnabled = true
    }

    defaultConfig {
        applicationId = "com.phaseguard.phaseguard"
<<<<<<< HEAD
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
=======
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion  // Required for Agora RTC Engine
        targetSdk = 36  // Required for Firebase and other plugin compatibility
        // Uses the version code from pubspec.yaml. When using split APKs, 1000 * ABI_VERSION
        // is added automatically by Flutter. (https://developer.android.com/studio/build/configure-apk-splits#configure-APK-versions)
        // You can force using the value of versionCode by specifying the `-P force-version-code-ignoring-abi=true`
        // flag during build.
>>>>>>> dishti/feature/android-compose-ui
        versionCode = flutter.versionCode
        versionName = flutter.versionName
        // arm64-v8a = real Android phones, x86_64 = emulator
        ndk {
            abiFilters += listOf("arm64-v8a", "x86_64")
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

<<<<<<< HEAD
    packaging {
        jniLibs {
            useLegacyPackaging = true
=======
    // Disable AAR metadata check for Agora compatibility
    tasks.whenTaskAdded {
        if (name.contains("checkAarMetadata")) {
            enabled = false
>>>>>>> dishti/feature/android-compose-ui
        }
    }
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    // Firebase dependencies
    implementation(platform("com.google.firebase:firebase-bom:34.19.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
}

flutter {
    source = "../.."
}

dependencies {
    val shizukuVersion = "13.1.5"
    implementation("dev.rikka.shizuku:api:$shizukuVersion")
    implementation("dev.rikka.shizuku:provider:$shizukuVersion")
    implementation("org.lsposed.hiddenapibypass:hiddenapibypass:4.3")
}
