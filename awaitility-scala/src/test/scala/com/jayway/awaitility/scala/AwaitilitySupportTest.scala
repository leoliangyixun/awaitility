/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jayway.awaitility.scala

import org.junit._
import com.jayway.awaitility.Awaitility._;


@Test
class AwaitilitySupportTest extends AwaitilitySupport {
	class Counter {
		var value = 0
		def count() = {
			value = value + 1
			value
		}
	}

    @Test
    def functionAsCondition() = {
		val c1 = new Counter()
		val c2 = new Counter()
		await until { c1.count() + c2.count() > 3 }
		await until { isDone() }
		await until isDone 
	}
	
	def isDone() : Boolean = true

	var c = 0
	def count() = {
		c = c + 1
		c
	}
}
