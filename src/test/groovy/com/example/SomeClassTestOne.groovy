package com.example

import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Before
import org.junit.Test

class SomeClassTestOne {
    private SomeClass someClass

    @Before
    void setUp() {
        println("I am in the before")

        someClass = new SomeClass()
    }

    @After
    void tearDown() {
        println("I am in the after")
    }

    @Test
    void testSomething() {
//        def a = 1_457_366_400_000L
//        def a = 1_457_366_400_000L
//        def a = 1_457L
        Assertions.assertThat(true).isTrue()
    }
}
