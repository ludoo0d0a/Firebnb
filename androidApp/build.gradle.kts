plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.firebnb.android"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.activity:activity-compose:1.7.2")
}