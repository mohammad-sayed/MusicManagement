import com.android.build.api.dsl.ApplicationDefaultConfig
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

private object BuildTypes {
    const val DEBUG = "debug"
    const val RELEASE = "release"
}

private object ProductFlavors {
    const val QA = "qa"
    const val PRODUCTION = "production"
}

private object FlavorDimensions {
    const val DEFAULT = "default"
}

android {
    namespace = ConfigData.nameSpace
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        prepareLastFMKeys(applicationDefaultConfig = this)
    }

    flavorDimensions.add(FlavorDimensions.DEFAULT)

    productFlavors {
        create(ProductFlavors.QA) {}
        create(ProductFlavors.PRODUCTION) {}
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

    prepareBaseUrl(baseAppModuleExtension = this)

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
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

/***
 * Create BASE_URL for API requests
 */
fun prepareBaseUrl(baseAppModuleExtension: BaseAppModuleExtension) {
    val gradleProperties = Properties().apply {
        load(project.rootProject.file("gradle.properties").inputStream())
    }
    baseAppModuleExtension.productFlavors.forEach { flavor ->
        val baseUrl = gradleProperties.getProperty("${flavor.name}_base_url")
        flavor.buildConfigField("String", "BASE_URL", baseUrl)
    }
}

/***
 * Create needed Keys for LastFM API requests
 */
fun prepareLastFMKeys(applicationDefaultConfig: ApplicationDefaultConfig) {
    val localProperties = Properties().apply {
        val file = project.rootProject.file("local.properties")
        if (file.exists()) {
            load(file.inputStream())
        }
    }
    val lastFMApiKey = localProperties.getProperty("LAST_FM_API_KEY")
    if (lastFMApiKey.isNullOrEmpty()) {
        throw RuntimeException("Couldn't find LastFM API Key.")
    }
    applicationDefaultConfig.buildConfigField("String", "LAST_FM_API_KEY", lastFMApiKey)
    val lastFMSharedSecret = localProperties.getProperty("LAST_FM_SHARED_SECRET")
    if (lastFMSharedSecret.isNullOrEmpty()) {
        throw RuntimeException("Couldn't find LastFM Shared Secret.")
    }
    applicationDefaultConfig.buildConfigField("String", "LAST_FM_SHARED_SECRET", lastFMApiKey)
}

dependencies {

    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.constraintLayoutCompose)

    //Image loading
    implementation(Dependencies.coil)
    //Controlling System UI
    implementation(Dependencies.accompanistSystemUiController)
    //Animations for Navigation
    implementation(Dependencies.accompanistNavigationAnimation)
    //To use Pagers in Jetpack Compose
    implementation(Dependencies.accompanistPager)
    //To use dependency Injection
    implementation(Dependencies.koin)
    //To use Permission in Compose
    implementation(Dependencies.accompanistPermissions)
    //Backend Restful APIs
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConverterGson)
    //Logging requests and responses
    implementation(Dependencies.loggingInterceptor)
    //Image loading
    implementation(Dependencies.coil)
    //Flow layout
    implementation(Dependencies.flowLayout)

    //Room
    implementation(Dependencies.room)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomKtx)


    //To allow using of java.time classes
    coreLibraryDesugaring(Dependencies.androidDesugaring)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.testExt)
    androidTestImplementation(Dependencies.testEspressoCore)
    androidTestImplementation(Dependencies.composeUiTestJUnit)
    debugImplementation(Dependencies.composeUiTooling)
}
