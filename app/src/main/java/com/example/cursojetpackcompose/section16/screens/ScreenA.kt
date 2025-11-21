package com.example.cursojetpackcompose.section16.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ScreenA(navController: NavHostController) {
    var message by remember { mutableStateOf("") }

    val currentEntry = navController.currentBackStackEntry

    LaunchedEffect(currentEntry) {
        currentEntry
            ?.savedStateHandle
            ?.getLiveData<String>("result")
            ?.observeForever { value -> //Esta me devolvera un valor de la variable result
                message = value
                currentEntry.savedStateHandle.remove<String>("result")
            }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Screen A",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = {
                navController.navigate("screenB")
            }
        ) {
            Text(
                text = "Screen B"
            )
        }

    }

    if (message.isNotEmpty()) {
        Text(
            text = "mensaje enviado desde Screen B: $message",
        )
    }
}
