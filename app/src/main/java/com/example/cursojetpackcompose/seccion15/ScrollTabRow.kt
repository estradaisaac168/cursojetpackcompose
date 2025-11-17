package com.example.cursojetpackcompose.seccion15

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScrollTabRow(){
    val tabTitles = listOf("Inicio", "Favorito", "Perfil", "Search", "Configuracion", "Notificacion")

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.statusBarsPadding(), //Evita super posicion con la barra de estado
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                edgePadding = 12.dp, //A los lados del scroll
                indicator = { tabPosition ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPosition[selectedTabIndex]),
                        color = MaterialTheme.colorScheme.primary
                    )

                }
            ) {
                tabTitles.forEachIndexed { index, title ->

                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        modifier = Modifier.padding(horizontal = 4.dp),
                        enabled = true,
                        text = {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.labelLarge
                            )

                        }
                    )
                }
            }
        }
    ) {
            paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding( 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = tabTitles[selectedTabIndex],
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}