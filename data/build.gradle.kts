plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
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
}

dependencies {

    //Hilt
    implementation (Dependencies.Hilt.hiltAndroid)
    kapt (Dependencies.Hilt.hiltAndroidCompiler)

    //Flow
    implementation (Dependencies.Coroutines.core)

    //Retrofit2
    implementation (Dependencies.Network.retrofit)
    implementation (Dependencies.Network.retrofitGson)
}