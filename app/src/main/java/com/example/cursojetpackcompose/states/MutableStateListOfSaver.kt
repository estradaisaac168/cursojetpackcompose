package com.example.cursojetpackcompose.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Saver es un mecanismo que permite Guardar y restaurar el estado de un objeto personalizado
//o complejo cuando usamos rememberSaveable, por ejemplo si se gira la pantalla... mutableStateList no puede hacerlo por si sola

/*
tiene dos funciones una es save y la otra restore
save convierte mi objeto a un formato que se pueda guardar
restore convierte ese nuevo formato guardado al objeto original cuando se necesita restaurar el estado*/
//mutableStateListOf....
val listSaver = listSaver<SnapshotStateList<String>, String>(
    save = {
        it.toList()
    },
    restore = {
        it.toMutableStateList()
    }
)


@Composable
fun MutableStateListOfSaver(){

    val itemsList = rememberSaveable( saver = listSaver){
        mutableStateListOf<String>("Item 1", "Item 2", "Item 3")
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = { itemsList.add("Item${itemsList.size + 1}") }
        ){
            Text(text = "Agregar Item")
        }

        Spacer(modifier = Modifier.height(4.dp))

        LazyColumn{
            items(itemsList){ item ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = item,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        IconButton(
                            onClick = { itemsList.remove(item) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Eliminar"
                            )
                        }
                    }
                }
            }
        }
    }

}