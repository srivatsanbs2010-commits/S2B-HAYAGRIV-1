plugins {
    id("com.android.application") version "8.7.3"
    id("org.jetbrains.kotlin.android") version "2.0.21"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
}

android {
    namespace = "com.s2b.hayagriva"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.s2b.hayagriva"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    /*
     * Flat Android project.
     *
     * Kotlin/Java files are kept at the repository root.
     * We explicitly provide only Kotlin/Java source files so
     * Gradle does not scan its own build directory.
     */
    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")

            java.setSrcDirs(
                listOf(
                    fileTree(".") {
                        include("**/*.kt")
                        include("**/*.java")

                        exclude("build/**")
                        exclude(".gradle/**")
                        exclude(".git/**")
                        exclude(".github/**")
                        exclude("gradle/**")
                        exclude(".idea/**")
                    }
                )
            )

            res.srcDir("res")
            assets.srcDir("assets")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")

    implementation("androidx.activity:activity-compose:1.10.1")

    implementation(
        platform("androidx.compose:compose-bom:2025.01.00")
    )

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    debugImplementation("androidx.compose.ui:ui-tooling")
}
