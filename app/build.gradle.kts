plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.sanphamdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sanphamdemo"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation ("com.google.code.gson:gson:2.9.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("de.hdodenhof:circleimageview:2.2.0")

    implementation ("com.github.bumptech.glide:glide:4.16.0")
   // implementation ("com.github.arimorty:floatingsearchview:2.1.1") // Phiên bản cụ thể bạn đang sử dụng

// Hoặc sử dụng phiên bản mới nhất (điều này cần kiểm tra phiên bản mới nhất trên GitHub hoặc Maven Central)
// implementation 'com.github.arimorty:floatingsearchview:latest_version'



}