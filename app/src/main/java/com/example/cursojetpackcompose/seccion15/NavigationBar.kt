package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed


/**
 * Con esto los iconos se reparte el espacio de los iconos
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBar(){
    //Variable que controla la visibilidad del ExpandedFloatingActionButton
    var isExpanded by remember { mutableStateOf(true) }


     //las listas son inmutables, no se pueden modificar
    val items = listOf( //Lista de etiquetas
        "Inicio",
        "Buscar",
        "Mensajes"
    )

    val icons = listOf( //Lista de iconos
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.MailOutline
    )

    var selectedItem by rememberSaveable() { mutableStateOf(0) } //Estado inicial, item seleccionado sera inicio


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
        bottomBar = { //No se puede BottonAppBar y NavigationBar al mismo tiempo o es uno o el otro
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                tonalElevation = 10.dp, //Produndidad a la barra
                windowInsets = NavigationBarDefaults.windowInsets //

            ){
                items.forEachIndexed { index, label ->
                    NavigationBarItem(
                        selected = selectedItem == index, //Si el item seleccionado es el actual, se mostrara en negrita
                        onClick = { selectedItem = index },
                        icon = { //Icono del item
                            Icon(
                                imageVector = icons[index], //"Inicio","Buscar","Mensajes" segun el indice
                                contentDescription = label //Nombre de la etiqueta
                            )

                        },
                        label = { //Etiqueta del item
                            Text(
                                text = label,
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        alwaysShowLabel = true, //Simepre se muestre el texto
                    )
                }
            }
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
                text = {
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
                    text = "Pantalla ${items[selectedItem]}",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    )
}