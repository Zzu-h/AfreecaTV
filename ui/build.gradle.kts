plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(Project.domain))

    implementation (Dependencies.Androidx.core)
    implementation (Dependencies.Androidx.appcompat)
    implementation (Dependencies.Material.material)
    implementation (Dependencies.Androidx.constraintLayout)
    implementation (Dependencies.Androidx.navFragmentKtx)
    implementation (Dependencies.Androidx.navUiKtx)
    testImplementation (Dependencies.Test.junit)
    testImplementation (Dependencies.Coroutines.test)
    testImplementation (Dependencies.Network.mockWebServer)
    androidTestImplementation (Dependencies.Coroutines.test)
    androidTestImplementation (Dependencies.Androidx.junit)
    androidTestImplementation (Dependencies.Androidx.espresso)

    //Hilt
    implementation (Dependencies.Hilt.hiltAndroid)
    kapt (Dependencies.Hilt.hiltAndroidCompiler)
    kapt (Dependencies.Hilt.hiltCompiler)

    //Flow
    implementation (Dependencies.Coroutines.core)

    //Coil
    implementation (Dependencies.Coil.coil)

    //Retrofit2
    implementation (Dependencies.Network.retrofit)
    implementation (Dependencies.Network.retrofitGson)

    implementation (Dependencies.Androidx.recyclerView)

    //ktx
    implementation (Dependencies.Androidx.activityKtx)
    implementation (Dependencies.Androidx.fragmentKtx)
    implementation (Dependencies.Androidx.viewModelKtx)

    //SwipeRefreshLayout
    implementation (Dependencies.Androidx.swipeRefreshLayout)

    //Paging3
    implementation (Dependencies.Paging.paging)
    implementation (Dependencies.Paging.pagingKtx)
}