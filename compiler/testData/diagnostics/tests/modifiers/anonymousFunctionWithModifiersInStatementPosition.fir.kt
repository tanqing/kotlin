// RUN_PIPELINE_TILL: FRONTEND
fun test() {
    <!NOT_YET_SUPPORTED_LOCAL_INLINE_FUNCTION!>inline<!> fun() {}
    <!NO_TAIL_CALLS_FOUND!>tailrec<!> fun() {}
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun() {}
    <!EXTERNAL_DECLARATION_CANNOT_HAVE_BODY!>external<!> fun() {}
    <!INAPPLICABLE_INFIX_MODIFIER!>infix<!> fun() {}
    <!ANONYMOUS_SUSPEND_FUNCTION!>suspend<!> fun() {}
    <!EXPECTED_DECLARATION_WITH_BODY!><!NOT_A_MULTIPLATFORM_COMPILATION, WRONG_MODIFIER_TARGET!>expect<!> fun()<!> {}
    <!NOT_A_MULTIPLATFORM_COMPILATION, WRONG_MODIFIER_TARGET!>actual<!> fun() {}
    <!WRONG_MODIFIER_TARGET!>override<!> fun() {}
}

/* GENERATED_FIR_TAGS: anonymousFunction, functionDeclaration */
