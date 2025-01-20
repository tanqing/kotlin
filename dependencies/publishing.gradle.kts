buildscript {
    repositories {
        maven(
            url = "https://maven.aliyun.com/repository/central",
            action = {
                isAllowInsecureProtocol = true
            }
        )
        maven(
            url = "https://maven.aliyun.com/repository/public",
            action = {
                isAllowInsecureProtocol = true
            }
        )
//        maven("https://plugins.gradle.org/m2")
    }
}

apply(plugin = "maven-publish")

val archives by configurations

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            setArtifacts(archives.artifacts)
        }
    }

    repositories {
        maven(
            url = "https://maven.aliyun.com/repository/central",
            action = {
                isAllowInsecureProtocol = true
            }
        )
        maven(
            url = "https://maven.aliyun.com/repository/public",
            action = {
                isAllowInsecureProtocol = true
            }
        )
        maven {
            name = "kotlinSpace"
            url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-dependencies")
            credentials(org.gradle.api.artifacts.repositories.PasswordCredentials::class)
        }
    }
}