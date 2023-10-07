import dependencies.addEntityModule
import dependencies.addRoomDependencies

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.xt.domain"
}

dependencies {
    addRoomDependencies()
    addEntityModule(configurationName = "api")
}