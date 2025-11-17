package com.example.cursojetpackcompose.seccion15

import android.R
import android.R.attr.horizontalDivider
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * No va dentro del Scafold
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(){
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    var scope = rememberCoroutineScope() //Con esto recordar si esta abierto o cerrado.

    val drawerLabelItems = listOf( //Lista de etiquetas
        "Inicio",
        "Buscar",
        "Mensajes"
    )

    val drawerIcons = listOf( //Lista de iconos
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.MailOutline
    )

    var selectedItem by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet{
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ){
                    //Avatar
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Avatar",
                        modifier = Modifier.size(72.dp).clip(CircleShape),
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Bienvenido",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    //Email del usuario
                    Text(
                        "usuario@gmail.com",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }

                HorizontalDivider()

                Text(
                    text = "Menu",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                drawerLabelItems.forEachIndexed { index, item ->
                    //Me devuelve la posicion del item
                    NavigationDrawerItem(
                        onClick = {
                            selectedItem = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        selected = selectedItem == index,
                        icon = {
                            Icon(
                                drawerIcons[index],
                                contentDescription = item
                            )
                        },
                        label = {
                            Text(text = item)
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        badge = {
                            if(index == 0){
                                Badge{
                                    Text("4")
                                }
                            }
                        },
                        shape = RoundedCornerShape(16.dp)
                    )
                }
            }
        },
        drawerState = drawerState, //Con esto identificamos si esta abierto o cerrado
        gesturesEnabled = true, //Habilitar que se abra el drawer deslizando el dedo
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Navigation Drawer",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ){
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            },
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            paddingValues -> //Me devuelve Padding interno
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues), //Le meto el padding interno
                contentAlignment = Alignment.Center
            ){
                Text(text = "Seccion: ${drawerLabelItems[selectedItem]}")
            }
        }
    }

}