package com.example.reflectionbasics.ui.screen.intro

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun IntroScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 50.dp)
    ) {

        Text(
            text = "Kotlin Reflection",
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Reflection is a set of language and library features that provides the feature of introspecting a given program at runtime. Kotlin reflection is used to utilize class and its members like properties, functions, constructors, etc. at runtime. ",
            style = TextStyle(fontWeight = FontWeight.SemiBold)
        )
    }
}