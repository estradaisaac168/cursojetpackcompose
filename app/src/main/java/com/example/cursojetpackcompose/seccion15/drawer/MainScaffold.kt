package com.example.cursojetpackcompose.seccion15.drawer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * onMenuClick -> el nombre del parametro
 * () -> Unit -> tipo de funcion que recibe ese parametro, osea no recibe parametros
 * () -> Esta funcion no retorna nada
 *
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    selectedSection : String,
    onMenuClick : () -> Unit
){
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
                            onMenuClick()
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
            Text(text = "Seccion: $selectedSection")
        }
    }
}