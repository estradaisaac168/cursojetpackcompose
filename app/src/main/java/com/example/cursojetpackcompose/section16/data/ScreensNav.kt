package com.example.cursojetpackcompose.section16.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class ScreensNav ( //Representa cada item del navigationbar
    val route : String, //homescreen
    val icon : ImageVector,
    val title : String
)

val screenBottom = listOf(
    ScreensNav("firstScreen", Icons.Default.Home, "First Screen"),
    ScreensNav("secondScreen", Icons.Default.Home, "Second Screen"),
    ScreensNav("thirdScreen", Icons.Default.Home, "Third Screen")
)