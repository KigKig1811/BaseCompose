import dependencies.addApiResponseModule
import dependencies.addDiModule
import dependencies.addDomainModule
import dependencies.addRoomDependencies

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.xt.data"
}

dependencies {
    addApiResponseModule(configurationName = "api")
    addRoomDependencies()
    addDiModule()
    addDomainModule()
}
