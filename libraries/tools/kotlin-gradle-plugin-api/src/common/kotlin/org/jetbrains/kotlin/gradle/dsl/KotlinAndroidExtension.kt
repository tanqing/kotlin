/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.dsl

import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget

/**
 * A plugin DSL extension for configuring Kotlin JVM options for the entire project.
 *
 * This extension is only available when "org.jetbrains.kotlin.android" plugin is applied in the project.
 *
 * Use the extension in your build script in the `kotlin` block:
 * ```kotlin
 * kotlin {
 *    // Your extension configuration
 * }
 * ```
 *
 * @since 2.1.0
 */
interface KotlinAndroidExtension : KotlinBaseExtension,
    HasConfigurableKotlinCompilerOptions<KotlinJvmCompilerOptions> {

    /**
     * An instance of [KotlinTarget] for [KotlinPlatformType.androidJvm] platform.
     */
    val target: KotlinTarget
}
