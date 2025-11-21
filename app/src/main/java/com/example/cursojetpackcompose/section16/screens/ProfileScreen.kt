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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cursojetpackcompose.R

@Composable
fun ProfileScreen(
    navController: NavHostController
) {
//fun ProfileScreen(name: String?) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.perfil),
            contentDescription = "Home",
            modifier = Modifier.size(80.dp)
        )

        Text(
//            text = "Profile Screen: \nWelcome $name",
            text = "Profile Screen: \nWelcome",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                navController.navigate("settingScreen"){
                    launchSingleTop = true //No se duplique la screen
                }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Go to Setting")
        }

        //Navegar a la pantalla anterior -> Home
        Button(
            onClick = {navController.popBackStack()}
        ) {
            Text(text = "Go to back")
        }
    }
}