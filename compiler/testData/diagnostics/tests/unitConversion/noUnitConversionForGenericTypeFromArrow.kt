// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

class Either

infix fun <A, B, C> ((A) -> B).andThen(g: (B) -> C): (A) -> C = TODO()

fun unsafeRunAsync(cb: (Either) -> Unit) {}

fun runAsync(cb: (Either) -> Unit) {
    unsafeRunAsync(cb.andThen { })
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, infix,
lambdaLiteral, nullableType, typeParameter */
