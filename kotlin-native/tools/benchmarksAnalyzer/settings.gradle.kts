pluginManagement {
//    apply(from = "../../../repo/scripts/cache-redirector.settings.gradle.kts")
    apply(from = "../../../repo/scripts/kotlin-bootstrap.settings.gradle.kts")

    repositories {
        maven(
                url = "https://maven.aliyun.com/repository/gradle-plugin",
                action = {
                    isAllowInsecureProtocol = true
                }
        )
//        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-dependencies")
//        mavenCentral()
//        gradlePluginPortal()
    }
}
