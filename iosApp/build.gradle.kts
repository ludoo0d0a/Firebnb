plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    ios()
    sourceSets {
        val iosMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}
