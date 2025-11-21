package com.example.cursojetpackcompose.section16.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cursojetpackcompose.section16.screens.ScreenA
import com.example.cursojetpackcompose.section16.screens.ScreenB

@Composable
fun NavGraphReturnParameter(
    paddingValues: PaddingValues,
    navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "ScreenA",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable("ScreenA") {
            ScreenA(navController = navController)
        }
        composable("ScreenB") {
            ScreenB(navController = navController)
        }
    }
}