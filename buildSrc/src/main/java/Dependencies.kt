object Dependencies {
    const val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistVersion}"
    const val accompanistNavigationAnimation =
        "com.google.accompanist:accompanist-navigation-animation:${Versions.accompanistVersion}"
    const val accompanistPager =
        "com.google.accompanist:accompanist-pager:${Versions.accompanistVersion}"
    const val accompanistPermissions =
        "com.google.accompanist:accompanist-permissions:${Versions.accompanistVersion}"
    const val activityCompose =
        "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
    const val androidDesugaring =
        "com.android.tools:desugar_jdk_libs:${Versions.androidDesugaringVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coilVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val composeUiTooling =
        "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val composeUiTestJUnit =
        "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val constraintLayoutCompose =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutComposeVersion}"
    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"
    const val flowLayout =
        "com.google.accompanist:accompanist-flowlayout:${Versions.accompanistVersion}"
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val koin = "io.insert-koin:koin-androidx-compose:${Versions.koinVersion}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverterGson =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val room = "androidx.room:room-runtime:${Versions.testExtVersion}"
    const val roomCompiler = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExtVersion}"
    const val testEspressoCore =
        "androidx.test.espresso:espresso-core:${Versions.testEspressoCoreVersion}"
}

object BuildPlugins {
    val gradle by lazy { "com.android.tools.build:gradle:${Versions.gradlePluginVersion}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinPluginVersion}" }
}