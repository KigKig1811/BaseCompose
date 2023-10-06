import dependencies.addTimberDependencies

plugins {
   plugins.`android-core-library`
}

android {
    namespace = "com.xt.di"
}

dependencies {
    addTimberDependencies(configurationName = "api")
}