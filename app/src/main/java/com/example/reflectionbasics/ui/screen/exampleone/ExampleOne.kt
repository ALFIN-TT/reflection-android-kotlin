package com.example.reflectionbasics.ui.screen.exampleone

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExampleOne(navController: NavController) {
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
            text = "Reflection",
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Reflection is a set of language and library features that provides the feature of introspecting a given program at runtime. Kotlin reflection is used to utilize class and its members like properties, functions, constructors, etc. at runtime.",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text =
            "Class references\n" +
                    "To obtain a class reference at runtime which is statically known, use the class reference operator. Also, the reference to a class can also be obtained from the instances of the class, such references are known as bounded class references. Using instances, you obtain the reference to the exact type to which the object conforms to, in case of inheritance.",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = "// Reference obtained using class name\n" +
                    " val abc = ReflectionDemo::class",
            style = TextStyle(fontWeight = FontWeight.Light)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Function references\n " +
                    "We can obtain a functional reference to every named function that is defined in Kotlin. This can be done by preceding the function name with the :: operator. These functional references can then be used as parameters to other functions.",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = "fun isDivisibleBy3(a: Int): Boolean{\n" +
                    "    return a%3 == 0\n" +
                    "} \n\n" +
                    "// Function reference obtained using :: operator\n" +
                    "    val ref1 = ::isDivisibleBy3\n" +
                    "    val array = listOf<Int>(1,2,3,4,5,6,7,8,9)\n" +
                    "    println(array.filter(ref1))",
            style = TextStyle(fontWeight = FontWeight.Light)
        )


        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Property References \n" +
                    "We can obtain property reference in a similar fashion as that of function, using the :: operator. If the property belongs to a class then the class-name should also be specified with the :: operator. These property references allow us to treat a property as an object that is, we can obtain their values using get function or modify it using set function.",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = "class Property(var a: Float){\n" +
                    "}\n" +
                    "  \n" +
                    "val x = 10;\n" +
                    "  // Property Reference for a package level property\n" +
                    "    val z = ::x\n" +
                    "    println(z.get())\n" +
                    "    println(z.name)\n" +
                    "  \n" +
                    "    // Property Reference for a class property\n" +
                    "    val y = Property::a\n" +
                    "    println(y.get(Property(5.899f)))",
            style = TextStyle(fontWeight = FontWeight.Light)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Constructor References \n" +
                    "The references to constructors of a class can be obtained in a similar manner as the references for methods and properties. These references can be used as references to a function which returns an object of that type. However, these uses are rare.",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = "class Property(var a: Float){\n" +
                    "}\n" +
                    " // Constructor Reference\n" +
                    "    val y = ::Property\n" +
                    "    println(y.name)",
            style = TextStyle(fontWeight = FontWeight.Light)
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "note: Please check source code for understand Reflections",
            style = TextStyle(fontWeight = FontWeight.Light)
        )

    }
}

private fun workout() {
// Reflection is a set of language and library features that provides the feature of introspecting a given program at runtime. Kotlin reflection is used to utilize class and its members like properties, functions, constructors, etc. at runtime.

    // Class references
    // To obtain a class reference at runtime which is statically known, use the class reference operator. Also, the reference to a class can also be obtained from the instances of the class, such references are known as bounded class references. Using instances, you obtain the reference to the exact type to which the object conforms to, in case of inheritance.

    // Reference obtained using class name
    val reflectionDemo = ReflectionDemo::class.java
    println("This is a class reference $reflectionDemo")


    // Reference obtained using object
    val reflectionDemoObj = ReflectionDemo()
    println("This is a bounded class reference ${reflectionDemoObj::class}")


    // TODO please check Run and you can see the  log.
    // I/System.out: This is a class reference class com.example.reflectionbasics.ui.screen.exampleone.ReflectionDemo
    // I/System.out: This is a bounded class reference class com.example.reflectionbasics.ui.screen.exampleone.ReflectionDemo


    //Function references
    //We can obtain a functional reference to every named function that is defined in Kotlin. This can be done by preceding the function name with the :: operator. These functional references can then be used as parameters to other functions. In the case of overloaded functions, we can either explicitly specify the type of the function or it can be implicitly determined from the content.

    // Function reference obtained using :: operator
    val reference1 = ::isDivisibleBy3
    val array = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(array.filter(reference1))
    // TODO please check Run and you can see the  log.
    // I/System.out: [3, 6, 9]

    // Function reference obtained for an overloaded function by explicitly specifying the type
    val reference2: (String, String) -> String = ::add
    println(reference2)
    println(reference2.invoke("a", "b"))
    // TODO please check Run and you can see the  log.
    // I/System.out: fun add(kotlin.String, kotlin.String): kotlin.String
    // I/System.out: ab

    // Function reference obtained implicitly
    val x = add(3, 5)
    println(x)
    // TODO please check Run and you can see the  log.
    // I/System.out: 8


    // Property References
    // We can obtain property reference in a similar fashion as that of function, using the :: operator. If the property belongs to a class then the class-name should also be specified with the :: operator. These property references allow us to treat a property as an object that is, we can obtain their values using get function or modify it using set function.

    // Property Reference for a package level property
    val b = ::a
    println(b.get())
    println(b.name)
    // TODO please check Run and you can see the  log.
    // I/System.out: 10
    // I/System.out: a

    // Property Reference for a class property
    val y = Property::m
    println(y.get(Property((5.899f))))
    // TODO please check Run and you can see the  log.
    // I/System.out: 5.899


    // Constructor References
    // The references to constructors of a class can be obtained in a similar manner as the references for methods and properties. These references can be used as references to a function which returns an object of that type. However, these uses are rare.

    // Constructor Reference
    val property = ::Property
    println(property.name)
    // TODO please check Run and you can see the log.
    // I/System.out: <init>

}