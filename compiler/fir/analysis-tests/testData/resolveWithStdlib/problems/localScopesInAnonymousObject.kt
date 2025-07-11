// RUN_PIPELINE_TILL: BACKEND
val x = object {
    val someString = "123"

    private fun foo(): Unit = with(someString) {
        val presentations = mutableListOf<String>()
        bar(true)?.let {
            presentations.add(it)
        }
    }

    private fun bar(arg: Boolean) = with(someString) {
        if (arg) this else null
    }
}

fun owner() {
    class Local {
        val someString = "123"

        private fun foo(): Unit = with(someString) {
            val presentations = mutableListOf<String>()
            bar(true)?.let {
                presentations.add(it)
            }
        }

        private fun bar(arg: Boolean) = with(someString) {
            if (arg) this else null
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, ifExpression, lambdaLiteral,
localClass, localProperty, nullableType, propertyDeclaration, safeCall, stringLiteral, thisExpression */
