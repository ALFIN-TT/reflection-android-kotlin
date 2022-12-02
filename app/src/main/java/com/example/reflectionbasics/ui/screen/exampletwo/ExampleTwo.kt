package com.example.reflectionbasics.ui.screen.exampletwo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.math.BigDecimal
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.*

@Composable
fun ExampleTwo(navController: NavController) {
    DisplayContent()
    workout()
}

@Composable
private fun DisplayContent() {
    val scrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 22.dp, vertical = 22.dp)
            .verticalScroll(state = scrollableState)
    ) {

        Text(
            text = "Reflection is the name for the ability to inspect, load and interact with classes, fields, and methods at runtime. We can do this even when we don’t know what they are at compile time.",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "// MyClass::class.java.methods\n" +
                    " This breaks down into the following constructs:\n" +
                    "\n" +
                    "MyClass::class gives us the Kotlin Class representation for the MyClass class\n" +
                    ".java gives us the java.lang.Class equivalent\n" +
                    ".methods is a call to the java.lang.Class.getMethods() accessor method",
            style = TextStyle(fontWeight = FontWeight.Light)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Java Reflection",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = "data class ExampleDataClass(\n" +
                    "  val name: String, var enabled: Boolean)\n" +
                    "\n" +
                    "ExampleDataClass::class.java.methods.forEach(::println)\n" +
                    "" +
                    "Kotlin converts the returned types to the Kotlin representations as well.\n" +
                    "\n" +
                    "In the above, we get a kotlin.Array<Method> on which we can call forEach().",
            style = TextStyle(fontWeight = FontWeight.Light)
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

private fun workout() {

    // Reflection is the name for the ability to inspect, load and interact with classes, fields, and methods at runtime. We can do this even when we don’t know what they are at compile time.

    MyClass::class.java.methods

    // This breaks down into the following constructs:
    //1. MyClass::class gives us the Kotlin Class representation for the MyClass class
    //2. .java gives us the java.lang.Class equivalent
    //3. .methods is a call to the java.lang.Class.getMethods() accessor method.


    ExampleDataClass::class.java.declaredMethods.forEach(::println)
    // Kotlin converts the returned types to the Kotlin representations as well.
    //In the above, we get a kotlin.Array<Method> on which we can call forEach().
    // TODO check run and logs

    val stringKClass: KClass<String> = String::class
    val listClass = List::class//KClass<List>

    val _stringClass = String::class

    val name = "Your Name"
    val stringClass = name::class

    // TODO check run and logs
    //printing functions in class
    stringClass.functions.forEach(::println)

    //Kotlin adds to this the ability to obtain the Companion Object for an arbitrary class, and the Object instance for an Object class:

    println(stringClass::class.companionObject)//get null
    println(stringClass::class.companionObjectInstance)// get null
    //these statements print null because there is no companion object

    // lets check another class
    val testClass: KClass<TestClass> = TestClass::class
    println(testClass.companionObject)
    println(testClass.companionObjectInstance)
    //got this result.
    //I/System.out: class com.example.reflectionbasics.ui.screen.exampletwo.TestClass$Companion
    //I/System.out: com.example.reflectionbasics.ui.screen.exampletwo.TestClass$Companion@43fbdf8


    // play with companion object.
    val companionObjectInstanceOfTestClass =
        testClass.companionObjectInstance//companion object instance in our hand

    val companionObjectOfTestClass =
        companionObjectInstanceOfTestClass as TestClass.Companion// for accessing companion object.
    companionObjectOfTestClass.printName()
    println(companionObjectOfTestClass.TAG)
    // in this way we can access the companion object.

    val kClassCompanionObjectOfTestClass =
        testClass.companionObject as KClass<TestClass.Companion> //for getting all details of companion instance.
    //we can get all members.
    val members = kClassCompanionObjectOfTestClass.members
    members.forEach(::println)
    //we can get all function.
    val function = kClassCompanionObjectOfTestClass.functions
    function.forEach(::println)
    // in this way we can get all information of companion object


    //play with object.

    val bigDecimalClass = BigDecimal::class
    println(bigDecimalClass.constructors)
    println(bigDecimalClass.functions)
    println(bigDecimalClass.memberProperties)
    println(bigDecimalClass.memberExtensionFunctions)

    //create instance of class with multiple arguments (multiple parameters in constructor)
    val kClassOfTestClass: KClass<TestClass> = TestClass::class
    val instanceOfTestClass = kClassOfTestClass.primaryConstructor?.call(
        "Name", "Nick Name",
    )
    println(instanceOfTestClass.toString())
    println(instanceOfTestClass?.name)

    //create object of class that don't have arguments in constructor.
    val kClassOfMyClass: KClass<MyClass> = MyClass::class
    val instanceOfMyClass = kClassOfMyClass.createInstance()
    println(instanceOfMyClass)

    //In addition to being able to interact with Classes, we can also interact with Methods and Properties.
    //In exactly the same way as with classes, we can obtain a reference to a Method or Property using the:: operator.
    //Once we have obtained a method reference, we can call it as if was really the method in question. This is known as being a Callable Reference:

    val welcomeMeMethod = instanceOfTestClass!!::welcomeMe
    println(welcomeMeMethod())

    //In addition to this, we can get more information about the inputs and outputs of the method through this reference.
    println(welcomeMeMethod.name)
    println(welcomeMeMethod.parameters)
    println(welcomeMeMethod.returnType)
    println(welcomeMeMethod.annotations)


    // Kotlin Property References
    // This works exactly the same for Properties as well, though obviously, the details that can be obtained are different. Properties instead can inform us if they are constants, late initialized, or mutable:

    val nickNameProperty = instanceOfTestClass::nickName
    println(nickNameProperty.name)
    println(nickNameProperty.get())
    println(nickNameProperty.set("Changed Nickname"))
    println(nickNameProperty.get())

    // TODO for more check the path 'com.example.reflectionbasics.ExampleTwoUnitTest'
}
