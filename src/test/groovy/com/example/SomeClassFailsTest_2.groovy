/*
 * (C) Copyright 2018 Kevin Brown (silentkevin@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example

import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Before
import org.junit.Test

class SomeClassFailsTest_2 {
    private SomeOKClass someClass

    @Before
    void setUp() {
        println("I am in the before")

        someClass = new SomeOKClass()
    }

    @After
    void tearDown() {
        println("I am in the after")
    }

    @Test
    void testSomething() {
//        def a = 1_457_366_400_000L
        def a = 1_457L
        Assertions.assertThat(true).isTrue()
    }
}
