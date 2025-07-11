// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Bug.java

public interface Bug {
        <RET extends Bug> RET save();
}

// FILE: SubBug.java

public class SubBug implements Bug {
        public SubBug save() {
                return this;
        }
}

// FILE: Bug.kt

fun TestBug() {
   SubBug().save() // can resolve on subtype
   val bug: Bug = SubBug()
   bug.save<Bug>() // can resolve on supertype
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType, localProperty, propertyDeclaration */
