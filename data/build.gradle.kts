import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = Config.applicationId + ".data"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    val baseUrl: String = gradleLocalProperties(rootDir).getProperty("BASE_URL")
    val clientId: String = gradleLocalProperties(rootDir).getProperty("CLIENT_ID")

    defaultConfig {
        buildConfigField("String", "BASE_URL", baseUrl)
        buildConfigField("String", "CLIENT_ID", clientId)
    }
}

dependencies {

    //Hilt
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltAndroidCompiler)

    //Flow
    implementation(Dependencies.Coroutines.core)

    //Retrofit2
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.retrofitGson)
}