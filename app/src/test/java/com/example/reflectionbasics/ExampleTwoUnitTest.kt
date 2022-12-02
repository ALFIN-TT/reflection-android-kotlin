package com.example.reflectionbasics

import com.example.reflectionbasics.ui.screen.exampletwo.TestClass
import com.example.reflectionbasics.ui.screen.exampletwo.User
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.io.ByteArrayInputStream
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance


class ExampleTwoUnitTest {


    //class

    @Test
    fun qualifiedName_is_TestClass() {
        val testClass = TestClass::class
        assertEquals(
            "com.example.reflectionbasics.ui.screen.exampletwo.TestClass",
            testClass.qualifiedName
        )
    }

    @Test
    fun class_is_not_abstract() {
        val testClass = TestClass::class
        assertFalse(testClass.isAbstract)
    }

    @Test
    fun class_is_data_class() {
        val testClass = TestClass::class
        assertTrue(testClass.isData)
    }

    @Test
    fun class_is_not_companion_class() {
        val testClass = TestClass::class
        assertFalse(testClass.isCompanion)
    }

    @Test
    fun class_is_final_class() {
        val testClass = TestClass::class
        assertTrue(testClass.isFinal)
    }

    @Test
    fun class_is_not_sealed_class() {
        val testClass = TestClass::class
        assertFalse(testClass.isSealed)
    }


    //functions

    lateinit var userClass: KClass<User>
    lateinit var instanceOfUserClass: User

    @Before
    fun setUp() {
        userClass = User::class
        instanceOfUserClass = userClass.createInstance()

    }

    @Test
    fun function_name_is_printName() {
        val functionReference = instanceOfUserClass::printName
        assertEquals("printName", functionReference.name)
    }

    @Test
    fun function_is_not_suspend() {
        val functionReference = instanceOfUserClass::printName
        assertFalse(functionReference.isSuspend)
    }

    @Test
    fun function_is_not_external() {
        val functionReference = instanceOfUserClass::printName
        assertFalse(functionReference.isExternal)
    }

    @Test
    fun function_is_not_operator() {
        val functionReference = instanceOfUserClass::printName
        assertFalse(functionReference.isOperator)
    }

    @Test
    fun function_is_not_inline() {
        val functionReference = instanceOfUserClass::printName
        assertFalse(functionReference.isInline)

        //try this
        /*  val str = "Hello"
          val method = str::byteInputStream

          assertEquals(
              ByteArrayInputStream::class.starProjectedType,
              method.returnType)
          assertFalse(method.returnType.isMarkedNullable)

          assertEquals(1, method.parameters.size)
          assertTrue(method.parameters[0].isOptional)
          assertFalse(method.parameters[0].isVararg)
          assertEquals(
              Charset::class.starProjectedType,
              method.parameters[0].type)*/
    }
////https://www.baeldung.com/kotlin/reflection
}