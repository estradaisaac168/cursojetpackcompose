package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * Scaffold es un composable de alto nivel que proporciona una estructura base visual y de navegacion
 * para una pantalla en Jetpack Compose.
 *
 * Encargado de calcular y aplicar el espaciado automatico para que los elementos no se superpongan.
 *
 * Hace que toda la interfaz sea coherente y modular
 *
 * -TopAppBar
 * -BottomAppBar
 * -BottomNavigation
 * -FloatingActionButton
 * -Drawer
 * -Content
 */


@Composable
fun MyScaffoldScreen() {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        content = { paddingValues ->
            //Funcion lambda que contiene el Contenido principal de la pantalla
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Contenido de la pantalla principal",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    )
}

