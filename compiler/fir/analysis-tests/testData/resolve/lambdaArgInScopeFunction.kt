// RUN_PIPELINE_TILL: FRONTEND
// CHECK_TYPE
// ISSUE: KT-37070

class KotlinClass(private val name: String) : Comparable<KotlinClass> {
    override operator fun compareTo(other: KotlinClass): Int {
        return name.compareTo(other.name)
    }
}


// TESTCASE NUMBER: 1
fun case1(kotlinClass: KotlinClass?) {

    val value = kotlinClass?.let {
        it
    }

    value.checkType { _<KotlinClass?>() }

    val lambda = kotlinClass?.let {
        {it}
    }

    lambda.checkType { <!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>_<!><Function1<Unit, KotlinClass?>>() }
}
// TESTCASE NUMBER: 2
fun case2(kotlinClass: KotlinClass) {

    val value = kotlinClass.let {
        it
    }

    value.checkType { _<KotlinClass>() }

    val lambda = kotlinClass.let {
        {it}
    }

    lambda.checkType { <!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>_<!><Function1<Unit, KotlinClass?>>() }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, infix,
lambdaLiteral, localProperty, nullableType, operator, override, primaryConstructor, propertyDeclaration, safeCall,
typeParameter, typeWithExtension */
