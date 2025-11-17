package com.example.cursojetpackcompose.seccion15.drawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DrawerContent(
    drawerLabelItems: List<String>, //Lista de labels
    drawerIcons: List<ImageVector>, //Lista de iconos
    selectedItem: Int,
    onItemClick: (Int) -> Unit, //Recibe un entero pero no retorna nada
){
    ModalDrawerSheet{
        //Column
        DrawerHeader()
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
                    onItemClick(index)
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
}