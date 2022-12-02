package com.example.reflectionbasics.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reflectionbasics.ui.screen.exampleone.ExampleOne
import com.example.reflectionbasics.ui.screen.exampletwo.ExampleTwo
import com.example.reflectionbasics.ui.screen.intro.IntroScreen
import com.example.reflectionbasics.ui.screen.main.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.IntroScreen.route) {
            IntroScreen(navController = navController)
        }

        composable(Screen.ExampleOne.route) {
            ExampleOne(navController = navController)
        }

          composable(Screen.ExampleTwo.route) {
              ExampleTwo(navController = navController)
          }

         /*  composable(Screen.ExampleThree.route) {
              ExampleThree(navController = navController)
          }

          composable(Screen.ExampleFour.route) {
              ExampleFour(navController = navController)
          }

          composable(Screen.ExampleFive.route) {
              ExampleFive(navController = navController)
          }*/
    }

}


