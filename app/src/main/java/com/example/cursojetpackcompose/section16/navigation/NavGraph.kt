package com.example.cursojetpackcompose.section16.navigation

import android.provider.Settings
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cursojetpackcompose.section16.screens.HomeScreen
import com.example.cursojetpackcompose.section16.screens.LoginScreen
import com.example.cursojetpackcompose.section16.screens.ProfileScreen
import com.example.cursojetpackcompose.section16.screens.SettingScreen

//Gestionar la navegacion
@Composable
fun NavGraph(navController: NavHostController, padding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "loginScreen",
        modifier = Modifier.padding(padding)
    ) {
        composable("loginScreen") {
            LoginScreen(navController = navController)
        }
            //Normal navigation
        composable("profileScreen") {
            ProfileScreen(navController = navController) //Ha este no le pasaremos ningun parametro porque de aca no iremos a ninguna otra pantalla
        }

        //Navigation with arguments
//        composable("profileScreen/{name}",
//            arguments = listOf(
//                navArgument("name") {
//                    type = NavType.StringType
//                }
//            )
//        ) { backStackEntry -> //Accede a los argumentos que hemos pasado
//
//            val name = backStackEntry.arguments?.getString("name") ?: "Unknown"
//            ProfileScreen(navController = navController) //Ha este no le pasaremos ningun parametro porque de aca no iremos a ninguna otra pantalla
////            ProfileScreen(name) //Ha este no le pasaremos ningun parametro porque de aca no iremos a ninguna otra pantalla
//        }

        composable("homeScreen") {
            HomeScreen(navController = navController)
        }

        composable("settingScreen") {
            SettingScreen(navController = navController)
        }
    }
}