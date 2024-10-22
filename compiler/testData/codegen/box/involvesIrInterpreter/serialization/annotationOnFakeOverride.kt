// IGNORE_BACKEND_K1: JS_IR, JS_IR_ES6, WASM
// IGNORE_BACKEND_K2: JVM, JVM_IR, JS_IR, JS_IR_ES6, WASM, NATIVE
// ISSUE: KT-72356
// STOP_EVALUATION_CHECKS
// FILE: A.kt
annotation class A(val x: String)

@kotlin.annotation.Target(kotlin.annotation.AnnotationTarget.TYPE_PARAMETER)
annotation class Something

// FILE: B.kt
open class B { @A("String  ") fun foo() {} }

// FILE: E.kt
fun <          @Something X> bar() {}

// E has a fake override of foo(), which has annotation with const param having SAME source range as @Something, but in ANOTHER source file
class E : B()

fun box(): String {
    return "OK"
}