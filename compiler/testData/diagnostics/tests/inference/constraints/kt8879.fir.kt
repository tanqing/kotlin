// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

interface Inv<I>
interface Inv2<I>

fun <T: Inv2<T>> foo(klass: Inv<T>): String? = null

fun <X> bar(): Inv<X> = null!!

fun test() {
    <!CANNOT_INFER_PARAMETER_TYPE!>foo<!>(<!CANNOT_INFER_PARAMETER_TYPE!>bar<!>())
}

/* GENERATED_FIR_TAGS: checkNotNullCall, functionDeclaration, interfaceDeclaration, nullableType, typeConstraint,
typeParameter */
