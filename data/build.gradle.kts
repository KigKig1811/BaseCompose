import dependencies.addApiResponseModule
import dependencies.addDiModule
import dependencies.addDomainModule

plugins {
    plugins.`android-core-library`
}

android {
    namespace = "com.xt.data"
}

dependencies {
    addApiResponseModule(configurationName = "api")
    addDiModule()
    addDomainModule()
}