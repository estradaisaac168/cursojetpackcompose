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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Para este ejemplo estoy usando el patron StateHoisting

@Composable
fun MutableStateMapOf(){
    val users = remember { mutableStateMapOf<Int, String>(
        1 to "Ana",
        2 to "Maria",
        3 to "Jose"
    ) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Button(
            onClick = {
                val newId = (users.keys.maxOrNull() ?: 0) + 1
                users[newId] = "Nuevo usuario $newId"
            }
        ) {
            Text("Adicionar usuário")
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn() {
            items(users.toList()){ (id, name) ->
                UserItem(id=id, name=name, onDelete = { //onDelete es una funcion personalizada.
                    users.remove(id)
                })
            }
        }
    }
}

@Composable
fun UserItem(id: Int, name: String, onDelete: () -> String?) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column{
                Text("ID: $id")
                Text("Name: $name")
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = { onDelete() }) { //onDelete() function callback asignada al evento
                Text("Delete")
            }
        }
    }
}