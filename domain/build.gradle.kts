import dependencies.addEntityModule

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.xt.domain"
}

dependencies {
    addEntityModule(configurationName = "api")
}