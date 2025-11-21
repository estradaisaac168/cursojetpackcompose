package com.example.cursojetpackcompose.section16

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cursojetpackcompose.section16.data.screenBottom
import com.example.cursojetpackcompose.section16.navigation.NavGraphWithNavController

@Composable
fun NavigationBarWithNavController() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {

                //Que pantalla esta seleccionada
                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route //Con esto obtenemos la ruta actual

                screenBottom.forEach { screensNav -> //Nos devolvera una pantalla
                    NavigationBarItem(
                        selected = currentRoute == screensNav.route,
                        onClick = {
                            navController.navigate(screensNav.route) {
                                //Id de la primera pantalla definida en el NavHost
                                popUpTo(navController.graph.startDestinationId) {
                                    //Indicamos que queremos guardar el estado de la pantalla a la que estamos haciendo popUpTo
                                    saveState = true
                                }
                                //Evita que se agregue una copia de la misma pantalla si ya estamos en ella
                                launchSingleTop = true
                                restoreState =
                                    true //Permite recuperar el estado anterior por ejemplo (scroll, input) de la pantalla si fue save en el saveState
                            }
                        },
                        icon = {
                            Icon(screensNav.icon, contentDescription = screensNav.title)
                        },
                        label = {
                            Text(screensNav.title)
                        }

                    )
                }
            }
        }
    ) { paddingValues ->
        NavGraphWithNavController(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}