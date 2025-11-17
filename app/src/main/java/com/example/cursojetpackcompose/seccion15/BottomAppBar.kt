package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.unit.dp

/**
 * windowInsets
 *
 * Esta propiedad controla como el componente se adapta o responde a las areas ocupadas por el sistema operativo
 * Estas areas incluyen elementos como:
 *
 * La barra de navegacion inferior de Android(Inicio, volver, apps recientes)
 * La barra de estado superior(Senial, hora,bateria)
 * El teclado cuando aparece en la pantalla
 * Cualquier otro UI del sistema que pueda superponerse al contenido
 *
 * Examples:
 *
 * Si usamos windowInsets = WindowInsets.ime, el componente tomara en cuenta la altura del teclado para no quedar cubierto
 * Si usamos windowInsets = WindowInsets.navigationBar, se ajustara para no ser tapado por la barra de navegacion
 * Se puede usar windowInsets.none para ignorar todos los insets
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBar(){
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
                containerColor = MaterialTheme.colorScheme.primaryContainer, //Color de fondo del BottomAppBar
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer //Color de los iconos del BottomAppBar
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