package com.example.cursojetpackcompose.section16

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cursojetpackcompose.section16.navigation.NavGraphReturnParameter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationReturnParameter(){

    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = "TopAppBar") },
        ) },
    ) {
        paddingValues ->
        NavGraphReturnParameter(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}