package com.example.cursojetpackcompose.section16.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cursojetpackcompose.R

@Composable
fun SettingScreen(
    navController: NavController,
){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.configuracion),
            contentDescription = "Setting",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Setting Screen", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("loginScreen"){
                popUpTo(0) //Limpia la pila de navegación -> Pantalla login es la primera = 0
            } },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Logout")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("homeScreen"){
                    launchSingleTop = true
                    popUpTo("profileScreen") {
                        inclusive = true //Elimina la pantalla del stack a pantalla setting y a ttodo lo que este por encima
                    }
                }
            }
        ) {
            Text(text = "Go to Home")
        }
    }
}