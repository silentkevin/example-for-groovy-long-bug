package com.example

import groovy.transform.CompileStatic

@CompileStatic
class SomeClass {
    SomeClass() {
        println("I am being constructed ${this.getClass().getCanonicalName()}")
    }
}
