plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.navigation:navigation-compose:2.7.0")
            }
        }
        val iosMain by getting
    }
}

compose {
    kotlinCompilerPlugin.set("1.5.2")
}