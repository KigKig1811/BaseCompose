import dependencies.addCommonModule
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
    addCommonModule()
    addEntityModule(configurationName = "api")
}
