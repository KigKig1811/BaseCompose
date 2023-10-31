import dependencies.addApiResponseModule
import dependencies.addCommonModule
import dependencies.addDiModule
import dependencies.addDomainModule
import dependencies.addNetworkDependencies
import dependencies.addRoomDependencies
import java.lang.System.getProperty

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.xt.data"

    defaultConfig {
        buildConfigField("String", "TMDB_BASE_URL", "\"http://api.themoviedb.org/\"")
        buildConfigField("String", "TMDB_API_KEY", "\"${getProperty("local.properties", "tmdb_api_key") ?: System.getenv("TMDB_API_KEY")}\"")
    }

}

fun getProperty(filename: String, propName: String): String? {
    val propsFile = rootProject.file(filename)
    if (propsFile.exists()) {
        return com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir).getProperty(propName)
    } else {
        print("$filename does not exist!")
    }
    return null
}

dependencies {
    addApiResponseModule(configurationName = "api")
    addCommonModule()
    addDiModule()
    addDomainModule()
    addRoomDependencies()
}
