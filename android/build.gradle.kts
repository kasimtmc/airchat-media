// The Android side of airchat-media: microphone and speaker with Opus, camera and screen with H.264
// (MediaCodec), shared by AirChat and AirChat+. An app includes this directory as a Gradle project
// from its airchat-media submodule; the Android Gradle plugin comes from the app's build.
plugins {
    id("com.android.library")
}

android {
    namespace = "com.plyg.airchat.media"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}
