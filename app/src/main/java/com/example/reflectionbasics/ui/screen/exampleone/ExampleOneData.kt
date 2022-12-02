package com.example.reflectionbasics.ui.screen.exampleone

// A sample empty class
class ReflectionDemo {
}


fun add(a: Int,b: Int) : Int{
    return a+b;
}

fun add(a: String,b: String): String{
    return "$a$b"
}

fun isDivisibleBy3(a: Int): Boolean{
    return a%3 == 0
}


val a = 10;
class Property(var m: Float){
}