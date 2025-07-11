// RUN_PIPELINE_TILL: BACKEND
// FILE: Inheritor.java

public class Inheritor extends Second {
    public void foo(First first, String s, int i) {}
}

// FILE: Base.kt

interface First

open class Second {
    open fun First.foo(s: String, i: Int) {}
}

// FILE: Test.kt

class Tester : Inheritor(), First {
    fun test() {
        foo("abc", 456)
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, integerLiteral,
interfaceDeclaration, javaFunction, javaType, stringLiteral */
