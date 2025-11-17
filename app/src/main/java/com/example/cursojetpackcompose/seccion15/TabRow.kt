package com.example.cursojetpackcompose.seccion15

import android.R.attr.contentDescription
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TabRow(){
    val tabTitles = listOf<String>("Inicio", "Favorito", "Perfil")
    val tabIcons = listOf(
        Icons.Default.Home,
        Icons.Default.Favorite,
        Icons.Default.Person
    )

    var selectedTabIndex by remember { mutableStateOf(0) }

    //Sensor invisible que detecta con el usuario. efectos, animaciones, eventos
    val interactionSource = remember {
        List(tabTitles.size){
            MutableInteractionSource()
        }
    }

    Scaffold(
        topBar = {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.statusBarsPadding(),
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
                indicator = { tabPosition ->
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPosition[selectedTabIndex])
                            .height(3.dp),
                        color = MaterialTheme.colorScheme.primary

                    )

                },
                divider = @androidx.compose.runtime.Composable {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant,
                        thickness = 1.dp
                    )
                }
            ){
                tabTitles.forEachIndexed { index, title ->

                    //Con esta linea para este ejemplo la tab favorito esta desactivada
                    val enabled = index != 1 //Linea para inactivar el tab

                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            if(enabled) selectedTabIndex = index //Linea para inactivar el tab
//                            selectedTabIndex = index
                        },
                        modifier = Modifier.padding(horizontal = 4.dp),
                        enabled = enabled, //Linea para inactivar el tab
//                        enabled = true,
                        text = {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.labelLarge
                            )

                        },
                        icon =  {
                            Icon(
                                tabIcons[index],
                                contentDescription = title
                            )
                        },
                        interactionSource = interactionSource[index],
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant
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
            when(selectedTabIndex){
                0 -> Text("Inicio", style = MaterialTheme.typography.headlineMedium)
                1 -> Text("Favorito", style = MaterialTheme.typography.headlineMedium)
                2 -> Text("Perfil", style = MaterialTheme.typography.headlineMedium)
            }
        }
    }
}