package plugins

import AppConfig
import dependencies.addAndroLifeCycleDependencies
import dependencies.addAndroidComposeDependencies
import dependencies.addAndroidTestsDependencies
import dependencies.addCoilImageLoadingDependencies
import dependencies.addCommonModule
import dependencies.addCoroutinesAndroidDependencies
import dependencies.addDiModule
import dependencies.addDomainModule
import dependencies.addHiltDependencies
import dependencies.addPagingDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AppConfig.compileSdkVersion
    defaultConfig {
        minSdk = AppConfig.minSdkVersion
        testInstrumentationRunner = AppConfig.testRunner
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    addDiModule()
    addDomainModule()
    addCommonModule()

    addAndroidComposeDependencies()
    addAndroLifeCycleDependencies()
    addCoroutinesAndroidDependencies()
    addCoilImageLoadingDependencies()
    addHiltDependencies()
    addAndroidTestsDependencies()
    addPagingDependencies()
}
