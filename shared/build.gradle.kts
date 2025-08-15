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

                val voyagerVersion = "1.1.0-beta02"
                implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
                implementation("cafe.adriel.voyager:voyager-screenmodel:$voyagerVersion")
                implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")

                val coilVersion = "3.0.0-alpha06"
                implementation("io.coil-kt.coil3:coil-compose:$coilVersion")
                implementation("io.coil-kt.coil3:coil-network-ktor:$coilVersion")
            }
        }
        val androidMain by getting {
            dependencies {
            }
        }
        val iosMain by getting
    }
}

compose {
    kotlinCompilerPlugin.set("1.5.2")
}