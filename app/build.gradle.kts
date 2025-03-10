import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose)
}

android {
    namespace = "com.worldline.insa.template"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.worldline.insa.template"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeCompiler {
        includeSourceInformation = true
        featureFlags = setOf(
            ComposeFeatureFlag.OptimizeNonSkippingGroups
        )
    }

    packaging {
        resources.excludes.add("META-INF/**")
        resources.excludes.add("META-INF/*.kotlin_module")
        resources.excludes.add("**/attach_hotspot_windows.dll")
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.coil.compose)
    implementation(libs.androidx.benchmark.macro)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.retrofit)
    debugImplementation (libs.converter.gson)
    debugImplementation (libs.logging.interceptor)
    debugImplementation (libs.androidx.lifecycle.viewmodel.ktx)
    debugImplementation (libs.androidx.lifecycle.livedata.ktx)
    debugImplementation (libs.androidx.lifecycle.runtime.ktx.v260)
    implementation (libs.coil.compose.v222)
    implementation (libs.okhttp)
    implementation (libs.logging.interceptor.v4120)


}