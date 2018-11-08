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

class SomeOKClass {
    SomeOKClass() {
        println("I am being constructed ${this.getClass().getCanonicalName()}")
//        long doesntWork1 = 1_000L
//        long doesntWork2 = 1_457_366_400_000L
//        long doesntWork3 = 1_457_366_400_000
        long doesWork1 = 1_000
        long doesWork2 = new Long("1457366400000")
    }
}
