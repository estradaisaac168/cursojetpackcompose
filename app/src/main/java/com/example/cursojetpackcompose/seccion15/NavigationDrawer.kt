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
import com.example.cursojetpackcompose.seccion15.drawer.DrawerContent
import com.example.cursojetpackcompose.seccion15.drawer.MainScaffold
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
            //ModalDrawer
            DrawerContent(
                drawerLabelItems,
                drawerIcons,
                selectedItem,
                onItemClick = { index->
                    selectedItem = index

                    scope.launch {
                        drawerState.close()
                    }

                }
            )
        },
        drawerState = drawerState, //Con esto identificamos si esta abierto o cerrado
        gesturesEnabled = true, //Habilitar que se abra el drawer deslizando el dedo
    ) {
        MainScaffold(
            selectedSection = drawerLabelItems[selectedItem],
            onMenuClick = {
                scope.launch {
                    drawerState.open()
                }
            }
        )
    }
}