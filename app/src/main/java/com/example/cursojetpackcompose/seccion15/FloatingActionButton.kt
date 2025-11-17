package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloatingActionButton(){
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
//            FloatingActionButton(
//                onClick = { /*TODO*/ },
//                containerColor = MaterialTheme.colorScheme.tertiary, //Color de fondo del FloatingActionButton
//                contentColor = MaterialTheme.colorScheme.onTertiary, //Color del icono del FloatingActionButton
//                shape = CircleShape, //Forma del FloatingActionButton
//                elevation = FloatingActionButtonDefaults.elevation(
//                    defaultElevation = 6.dp, //Elevacion por defecto del FloatingActionButton
//                    hoveredElevation = 10.dp, //Elevacion al pasar el mouse por encima del FloatingActionButton
//                    pressedElevation = 8.dp //Elevacion al presionar el FloatingActionButton
//                )
//            ){
//                Icon(
//                    imageVector = Icons.Default.AddCircle,
//                    contentDescription = "AddCircle"
//                )
//            }


//            SmallFloatingActionButton(
//                onClick = { /*TODO*/ },
//                containerColor = MaterialTheme.colorScheme.tertiary, //Color de fondo del FloatingActionButton
//                contentColor = MaterialTheme.colorScheme.onTertiary, //Color del icono del FloatingActionButton
//                shape = CircleShape, //Forma del FloatingActionButton
//                elevation = FloatingActionButtonDefaults.elevation(
//                    defaultElevation = 6.dp, //Elevacion por defecto del FloatingActionButton
//                    hoveredElevation = 10.dp, //Elevacion al pasar el mouse por encima del FloatingActionButton
//                    pressedElevation = 8.dp //Elevacion al presionar el FloatingActionButton
//                )
//            ){
//                Icon(
//                    imageVector = Icons.Default.AddCircle,
//                    contentDescription = "AddCircle"
//                )
//            }


            LargeFloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.tertiary, //Color de fondo del FloatingActionButton
                contentColor = MaterialTheme.colorScheme.onTertiary, //Color del icono del FloatingActionButton
                shape = CircleShape, //Forma del FloatingActionButton
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 6.dp, //Elevacion por defecto del FloatingActionButton
                    hoveredElevation = 10.dp, //Elevacion al pasar el mouse por encima del FloatingActionButton
                    pressedElevation = 8.dp //Elevacion al presionar el FloatingActionButton
                )
            ){
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "AddCircle"
                )
            }
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