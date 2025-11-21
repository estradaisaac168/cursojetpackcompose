package com.example.cursojetpackcompose.section16

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cursojetpackcompose.section16.navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavControllerNavHost(){

    val navController = rememberNavController() //Gestiona la navegacion entre las rutas de las pantallas

    Scaffold(
        topBar = { TopAppBar(
                title = { Text(text = "Navegacion compose")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {paddingValues ->
        NavGraph(navController = navController, padding = paddingValues)
    }
}