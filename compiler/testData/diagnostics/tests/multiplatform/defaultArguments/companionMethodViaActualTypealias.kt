// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
expect class DefaultArgsInCompanion {
    companion object {
        fun foo(p: String = "")
    }
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
class DefaultArgsInCompanionImpl {
    companion object {
        fun foo(p: String) {}
    }
}

<!DEFAULT_ARGUMENTS_IN_EXPECT_WITH_ACTUAL_TYPEALIAS!>actual typealias DefaultArgsInCompanion = DefaultArgsInCompanionImpl<!>

/* GENERATED_FIR_TAGS: actual, classDeclaration, companionObject, expect, functionDeclaration, objectDeclaration,
stringLiteral, typeAliasDeclaration */
