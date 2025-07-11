// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// FIR_DUMP
// FILE: Base.java

public class Base {
    public String x = "";
}

// FILE: test.kt

interface Proxy {
    val x: String
}

open class Intermediate : Base() {
    val <!PROPERTY_HIDES_JAVA_FIELD!>x<!> get() = " "
}

class Derived : Proxy, Intermediate() {
    fun test() {
        x
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, getter, interfaceDeclaration, javaType,
propertyDeclaration, stringLiteral */
