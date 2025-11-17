package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * Util cuando se hace Scroll hacia abajo
 * o vuelve a inicio
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtendedFloatingActionButton(){

    //Variable que controla la visibilidad del ExpandedFloatingActionButton
    var isExpanded by remember { mutableStateOf(true) }

    Scaffold( //Estructura visual basica con Slots
        topBar = {
            //Funcion lambda que contiene el contenido del AppBar
            TopAppBar(
                title = { Text(text = "Pantalla con Scaffold") },
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
                },
                colors = TopAppBarDefaults.topAppBarColors( //Color de fondo del TopAppBar
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary, //Color del texto del titulo
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary, //Color del icono del menu
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary //Color del icono de la accion
                )
            )
        },
        bottomBar = {
            BottomAppBar( //Los iconos se alinean por defecto a la izquierda.
                actions = {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = "Build"
                        )
                    }


                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }


                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MailOutline,
                            contentDescription = "MailOutline"
                        )
                    }
                },
                tonalElevation = 6.dp,
                windowInsets = WindowInsets.navigationBars, //se muestre sobre la barra de navegacion del sistema
                containerColor = MaterialTheme.colorScheme.primary, //Color de fondo del BottomAppBar
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer //Color de los iconos del BottomAppBar
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    isExpanded = !isExpanded
                    println("EFAB ha sido presionado")
                },
                icon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send, // Se adapta segun el idioma y direccion
                        contentDescription = "Send"
                    )
                },
                text ={
                    Text(
                        "Enviar componente"
                    )
                },
                expanded = isExpanded,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(16.dp),
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 6.dp,
                    hoveredElevation = 10.dp,
                    pressedElevation = 8.dp
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