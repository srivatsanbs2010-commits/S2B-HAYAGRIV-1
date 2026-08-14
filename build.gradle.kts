import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

    sourceSets {
        getByName("main") {
            manifest.srcFile("AndroidManifest.xml")

            /*
             * The project is intentionally flat.
             * Kotlin/Java source files are located at the repository root.
             */
            java.srcDir(".")

            /*
             * IMPORTANT:
             * Do not allow Gradle's generated build files,
             * GitHub workflow files, or Gradle configuration files
             * to become Android source files.
             */
            java.exclude(
                "build/**",
                ".gradle/**",
                ".github/**",
                ".git/**",
                "gradle/**",
                ".idea/**",
                "*.gradle",
                "*.gradle.kts",
                "settings.gradle",
                "settings.gradle.kts",
                "gradlew",
                "gradlew.bat",
                "local.properties"
            )

            res.srcDir("res")
            assets.srcDir("assets")
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.activity:activity-compose:1.10.1")

    implementation(platform("androidx.compose:compose-bom:2025.01.00"))

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    debugImplementation("androidx.compose.ui:ui-tooling")
}
