// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
fun f() {
    foo {
        bar {
            <!RETURN_NOT_ALLOWED!>return@foo<!> 1
        }
        return@foo 1
    }
}

fun foo(a: Any) {}
fun bar(a: Any) {}

/* GENERATED_FIR_TAGS: functionDeclaration, integerLiteral, lambdaLiteral */
