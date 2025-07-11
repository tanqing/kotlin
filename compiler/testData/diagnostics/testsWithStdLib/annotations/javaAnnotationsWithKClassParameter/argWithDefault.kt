// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java
public @interface A {
    Class<?> arg() default Integer.class;
}

// FILE: b.kt
@A(arg = String::class) class MyClass1
@A class MyClass2

/* GENERATED_FIR_TAGS: classDeclaration, classReference, javaType */
