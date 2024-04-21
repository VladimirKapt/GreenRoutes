import com.android.build.gradle.internal.cxx.ninja.isPackageable

plugins {
    id ("com.android.application")
    id("com.google.gms.google-services")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.example.greenroutes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.greenroutes"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation ("com.google.android.material:material:1.11.0")
    implementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation ("com.squareup.okhttp3:logging-interceptor:4.7.2")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")

    implementation ("com.google.android.material:material:1.11.0")

    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.1")
    implementation ("com.firebaseui:firebase-ui-storage:7.2.0")
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    implementation("com.google.firebase:firebase-analytics")

    implementation ("com.google.android.gms:play-services-maps:18.2.0")

    implementation ("androidx.core:core-ktx:1.13.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("com.squareup.picasso:picasso:2.8")
}