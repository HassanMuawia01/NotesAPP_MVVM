// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("androidx.navigation.safeargs") version "2.5.3" apply false
    id ("com.android.library") version "7.4.1" apply false

}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.5")
      //  classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")

    }
}