// RUN_PIPELINE_TILL: FRONTEND
fun bar(x: Int): Int = x + 1

fun foo() {
    val x: Int? = null

    do {
        bar(<!TYPE_MISMATCH!>x<!>)
    } while (x == null)
    bar(<!DEBUG_INFO_SMARTCAST!>x<!>)

    val y: Int? = null
    do {
        bar(<!TYPE_MISMATCH!>y<!>)
    } while (y != null)
    bar(<!DEBUG_INFO_CONSTANT, TYPE_MISMATCH!>y<!>)
}

/* GENERATED_FIR_TAGS: additiveExpression, doWhileLoop, equalityExpression, functionDeclaration, integerLiteral,
localProperty, nullableType, propertyDeclaration, smartcast */
