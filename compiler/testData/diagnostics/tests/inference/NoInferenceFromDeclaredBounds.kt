// RUN_PIPELINE_TILL: FRONTEND
fun <T: Any> fooT22() : T? {
  return null
}

fun foo1() {
    <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>fooT22<!>()
}

val n : Nothing = null.sure()

fun <T : Any> T?.sure() : T = this!!

/* GENERATED_FIR_TAGS: checkNotNullCall, funWithExtensionReceiver, functionDeclaration, nullableType,
propertyDeclaration, thisExpression, typeConstraint, typeParameter */
