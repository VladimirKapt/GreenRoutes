// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath ("com.google.gms:google-services:4.4.1")
    }
}
plugins {
    id ("com.android.application") version "7.4.1" apply false
    //id ("com.android.library") version "7.4.1" apply false
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1" apply false
}