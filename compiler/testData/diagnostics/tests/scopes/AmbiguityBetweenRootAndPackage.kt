// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: root.kt
fun testFun() = "239"

// FILE: otherPackage.kt
package test

fun testFun() = 12

// FILE: using.kt
import test.*

val t: String = testFun()

/* GENERATED_FIR_TAGS: functionDeclaration, integerLiteral, propertyDeclaration, stringLiteral */
