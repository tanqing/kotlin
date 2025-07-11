plugins {
    kotlin("jvm")
    id("jps-compatible")
}

val compilerModules: Array<String> by rootProject.extra
val otherCompilerModules = compilerModules.filter { it != path }

val antLauncherJar by configurations.creating

dependencies {
    testImplementation(intellijCore())

    testApi(project(":kotlin-script-runtime"))

    testApi(kotlinStdlib())

    testApi(kotlinTest())
    testCompileOnly(kotlinTest("junit"))

    testImplementation(libs.junit4)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter.api)
    testImplementation(libs.junit.platform.launcher)

    testRuntimeOnly(libs.junit.jupiter.engine)
    testRuntimeOnly(libs.junit.vintage.engine)

    testApi(projectTests(":compiler:tests-common"))
    testApi(projectTests(":compiler:tests-common-new"))
    testApi(projectTests(":compiler:fir:raw-fir:psi2fir"))
    testApi(projectTests(":compiler:fir:raw-fir:light-tree2fir"))
    testApi(projectTests(":compiler:fir:analysis-tests:legacy-fir-tests"))
    testApi(projectTests(":generators:test-generator"))
    testApi(project(":compiler:ir.tree")) // used for deepCopyWithSymbols call that is removed by proguard from the compiler TODO: make it more straightforward
    testApi(project(":kotlin-scripting-compiler"))

    otherCompilerModules.forEach {
        testCompileOnly(project(it))
    }

    testImplementation(commonDependency("org.jetbrains.kotlin:kotlin-reflect")) { isTransitive = false }
    testCompileOnly(toolsJarApi())
    testRuntimeOnly(toolsJar())

    antLauncherJar(commonDependency("org.apache.ant", "ant"))
    antLauncherJar(toolsJar())
}

optInToExperimentalCompilerApi()
optInToK1Deprecation()

sourceSets {
    "main" { none() }
    "test" {
        projectDefault()
        generatedTestDir()
    }
}

projectTest(
    parallel = true,
    defineJDKEnvVariables = listOf(
        JdkMajorVersion.JDK_1_8,
        JdkMajorVersion.JDK_11_0,
        JdkMajorVersion.JDK_17_0,
        JdkMajorVersion.JDK_21_0
    ),
    jUnitMode = JUnitMode.JUnit4
) {
    dependsOn(":dist")
    dependsOn(":kotlin-stdlib:compileKotlinWasmJs")

    workingDir = rootDir

    useJUnitPlatform()

    systemProperty("kotlin.test.script.classpath", testSourceSet.output.classesDirs.joinToString(File.pathSeparator))
    val antLauncherJarPathProvider = project.provider {
        antLauncherJar.asPath
    }
    doFirst {
        systemProperty("kotlin.ant.classpath", antLauncherJarPathProvider.get())
        systemProperty("kotlin.ant.launcher.class", "org.apache.tools.ant.Main")
    }
}

testsJar()
