plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
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

    flavorDimensions += listOf("env")
    productFlavors {
        create("api") {
            dimension = "env"
        }
        create("local") {
            dimension = "env"
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

    packaging {
        resources.excludes.add("META-INF/**")
        resources.excludes.add("META-INF/*.kotlin_module")
        resources.excludes.add("**/attach_hotspot_windows.dll")
    }
}

dependencies {


    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":ui"))

    implementation(libs.androidx.core.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)




    implementation(libs.koin.android)


}