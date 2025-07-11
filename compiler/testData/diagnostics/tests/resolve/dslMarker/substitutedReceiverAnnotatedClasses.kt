// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
@DslMarker
annotation class Ann

@Ann
class A {
    fun a() = 1
}

@Ann
class B {
    fun b() = 2
}

fun <T> foo(x: T.() -> Unit) {}
fun <E> bar(x: E.() -> Unit) {}

fun test() {
    foo<A> {
        a()
        bar<B> {
            <!DSL_SCOPE_VIOLATION!>a<!>()
            this@foo.a()
            b()
        }
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, functionalType, integerLiteral,
lambdaLiteral, nullableType, thisExpression, typeParameter, typeWithExtension */
