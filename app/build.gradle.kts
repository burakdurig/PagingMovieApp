plugins {
    alias(libs.plugins.android.application)
    id ("com.google.dagger.hilt.android")

}

android {
    namespace = "com.mastercoding.pagingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mastercoding.pagingapp"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit and its converters
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
// RxJava3 with retrofit
    implementation("com.squareup.retrofit2:adapter-rxjava3:2.11.0")

    // Paging 3 Library [rare] : helps you load and display pages of data from a larger dataset
    // from local storage or over network. This approach allows your app to use both network
    // bandwidth and system resources more efficiently.
    val paging_version = "3.3.5"
    implementation ("androidx.paging:paging-runtime:$paging_version")
    // optional - RxJava3 support
    implementation ("androidx.paging:paging-rxjava3:$paging_version")


    // Dagger is a replacement for FactoryFactory classes that implements the dependency injection
    // design pattern without the burden of writing the boilerplate. This allows a module to be shared
    // across all of your apps and you can run DebLoggingModule during development and
    // ProdLoggingModule in production.
    // Dagger 2 is different in which it is the first ot implement the full stack with
    // generated code. the @Inject is used with dagger to annotate the consturctor that Dagger
    // should be used to create instances of a class.
    // -----------------------------------------------------
    // Hilt provides a standard way to incorporate Dagger defendency injection
    // into an Android application. Hilt works by code generating your Dagger setup code
    // for you taking away most of the boilerplate of using Dagger.
    implementation ("com.google.dagger:hilt-android:2.54")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.54")

    // Glide is used for displaying images.
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")

    // Lifecycle which handles thread resources the best
    val lifecycle_version = "2.8.7"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")



}