package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopBar(){
    /**
     * Este composable es mas personalizable
     */

    Scaffold(
        topBar = {
            //Funcion lambda que contiene el contenido del AppBar
            CenterAlignedTopAppBar(
                title = { Text(text = "CenterAligned") },
                navigationIcon = { //Se muestran a la izquierda del titulo
                    IconButton(
                        onClick = { /*TODO*/ }
                    ){
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = { //Se muestran a la derecha del titulo
                    IconButton(
                        onClick = { /*TODO*/ }
                    ){
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = "Build"
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ){
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "DateRange"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors( //Color de fondo del TopAppBar
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary, //Color del texto del titulo
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary, //Color del icono del menu
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary //Color del icono de la accion
                )
            )
        },
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