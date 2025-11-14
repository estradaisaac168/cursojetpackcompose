package com.example.cursojetpackcompose.SecondaryEffect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

//Una corrutina es un bloque de code azync que se ejecuta fuera del bloque principal
suspend fun getDataApi() : String{ //Solo puede ejecutarse dentro de una Corrutina
    delay(5000)
    return "Isaac Estrada"
}

@Composable
fun UserDataScreen(){
    var user by remember {mutableStateOf<String?>(null)} //Con null estamos indicando que user no tiene un valor asignado todavia.
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        user = getDataApi()
        isLoading = false
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (isLoading){
            CircularProgressIndicator()
        }else if (user != null){
            //Esto permite una llamada segura y se ejecuta lo que esta dentro de let
            user?.let {  //Con esta linea evitamos el null pointer exception
                Text(
                    "Bienvenido: ${it}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}