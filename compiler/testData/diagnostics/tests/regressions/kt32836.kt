// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

inline fun <reified T> parse(json: String): T? = TODO()

class MyType

fun parseMyData(json: String): MyType =
    try {
        parse(json) // error with new inf only: Cannot use 'Nothing?' as reified type parameter
            ?: throw IllegalArgumentException("Can't parse")
    } catch (e: Exception) {
        throw IllegalArgumentException("Can't parse")
    }

fun main() {
    parseMyData("")
}

/* GENERATED_FIR_TAGS: classDeclaration, elvisExpression, functionDeclaration, inline, localProperty, nullableType,
propertyDeclaration, reified, stringLiteral, tryExpression, typeParameter */
