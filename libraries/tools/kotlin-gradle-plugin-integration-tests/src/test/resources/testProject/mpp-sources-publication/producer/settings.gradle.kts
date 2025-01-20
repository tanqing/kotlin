pluginManagement {
	repositories {
		maven(url = "https://maven.aliyun.com/repository/central")
		maven(url = "https://maven.aliyun.com/repository/public")
		maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
		mavenLocal()
//		gradlePluginPortal()
	}
	val kotlin_version: String by settings
	plugins {
		val test_fixes_version: String by settings
		kotlin("multiplatform").version(kotlin_version)
		id("org.jetbrains.kotlin.test.fixes.android") version test_fixes_version
	}
}

rootProject.name = "lib"