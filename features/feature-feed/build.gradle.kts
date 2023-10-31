import dependencies.addCommonModule

plugins {
    plugins.`android-feature-library`
}

android {
    namespace = "com.xt.feature_feed"
}

dependencies {
    addCommonModule()
}
