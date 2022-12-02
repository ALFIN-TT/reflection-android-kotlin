package com.example.reflectionbasics.ui.screen.exampletwo

import androidx.annotation.NonNull


class MyClass

data class ExampleDataClass(val name: String, var enabled: Boolean)

data class TestClass(val name: String, var nickName: String) {

    var age: Int = 1

    companion object {
        val TAG = TestClass::class.simpleName
        fun printName() {
            println("I'm companion method, you can call me directly.")
        }

    }


    @NonNull
    fun welcomeMe() = "Hello $name"
    fun introduceMe() = "Hi all,\n this is $name and his/her nick name is $nickName"

}

class User {
    var name = "User"
    fun printName() {
        println(name)
    }
}

abstract class Student
class Boy : Student()
class Girl : Student()