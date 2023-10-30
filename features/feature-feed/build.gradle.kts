import dependencies.addCommonModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.xt.feature-feed"
}

dependencies {
    addCommonModule()
}
