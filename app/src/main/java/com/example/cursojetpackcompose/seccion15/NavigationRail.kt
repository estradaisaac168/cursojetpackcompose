package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cursojetpackcompose.R

//Se borra el NavigationBar ya que es el mismo resultado
//Util para tablets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationRail(){
    //Variable que controla la visibilidad del ExpandedFloatingActionButton
    var isExpanded by remember { mutableStateOf(true) }


    //las listas son inmutables, no se pueden modificar
    val items = listOf( //Lista de etiquetas
        "Inicio",
        "Buscar",
        "Mensajes",
        "Perfil",
        "Configuración",
        "Ayuda",
        "Acerca de",
        "Cerrar Sesión"
    )

    val icons = listOf( //Lista de iconos
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.MailOutline,
        Icons.Default.AccountCircle,
        Icons.Default.Settings,
        Icons.Default.Delete,
        Icons.Default.Info,
        Icons.Default.Close
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
            //Aca se implementa el NavigationRail ira dentro de un Row barra lateral y contenido
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NavigationRail(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    header = {
                        Image(
//                            painter = painterResource(id = R.drawable.fotoperfil),
                            painter = rememberAsyncImagePainter(
                               "https://cdn.pixabay.com/photo/2020/03/15/13/15/desert-4933581_1280.jpg"
                            ),
                            contentDescription = "User",
                            modifier = Modifier
                                .padding(16.dp)
                                .size(48.dp)
                                .clip(CircleShape)
                        )
                    }
                ){
                    items.forEachIndexed { index, item ->
                        NavigationRailItem(
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            icon = {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = item
                                )
                            },
                            label = { Text(item) },
                            alwaysShowLabel = false,
                            enabled = true
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding( 32.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Pantalla: ${items[selectedItem]}",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    )
}