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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun CounterLifeCycle(){

    var count by remember { mutableIntStateOf(0) }

    /*
    * Se ejecuta por primera vez cuando este composable se muestre por primera vez en pantalla
    * Unit -> Efecto que solo se ejecute una vez*/
    LaunchedEffect(Unit) {
        println("Se ejecuta una vez, La pantalla se esta componiendo")
    }

    println("La pantalla se esta recomponiendo")


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: $count",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            Text(text = "Incrementar")
        }

    }
}

//Tema sobre Claves en recomposicion
data class Task(val id: String, val description: String)


/*
* como esta lista me devuelve un listof lo que significa que es inmutable no puede cambiar*/
fun initialTaskList() : List<Task>{
    return listOf(
        Task(UUID.randomUUID().toString(), "Task 1"),
        Task(UUID.randomUUID().toString(), "Task 2"),
        Task(UUID.randomUUID().toString(), "Task 3"),
        Task(UUID.randomUUID().toString(), "Task 4"),
        Task(UUID.randomUUID().toString(), "Task 5"),
        Task(UUID.randomUUID().toString(), "Task 6"),
        Task(UUID.randomUUID().toString(), "Task 7"),
        Task(UUID.randomUUID().toString(), "Task 8"),
        Task(UUID.randomUUID().toString(), "Task 9"),
        Task(UUID.randomUUID().toString(), "Task 10"),
    )
}


@Composable
fun TaskListScreen(){
    var tasks by remember {mutableStateOf(initialTaskList())} //Envolviendo la lista inmutable a un estado mutable

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                tasks = tasks + Task(UUID.randomUUID().toString(), "New Task")
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.Center){
            //Cada tarea tendra su propio identificador, claves en composicion.
            items(tasks, key = {it.id}){ task ->
                ItemTask(
                    task = task,
                    onDelete = { taskToDelete ->
                        tasks = tasks.filter {it.id != taskToDelete.id}
                    }
                )
            }
        }

    }
}

@Composable
fun ItemTask(task: Task, onDelete: (Task) -> Unit) { //No devuelve nada por eso colocamos Unit
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(12.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = task.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            IconButton(onClick = { onDelete(task) }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Task"
                )
            }
        }
    }
}

