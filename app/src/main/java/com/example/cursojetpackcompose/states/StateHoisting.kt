package com.example.cursojetpackcompose.states

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//Este componente sera el padre porque aca estoy declarando el estado.
@Composable
fun StateHoisting(){ //Patron estado elevado -> serie de pasos para cumplir con este patron
    var text by rememberSaveable() {mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Este es el hijo porque esta recibiendo el estado del padre.
        /*
        text => El estado,
        onTextChange => Funcion Callback
         */
        MyOutlinedTextField(text = text, onTextChange = {text = it})
    }
}

@Composable
fun MyOutlinedTextField(text: String, onTextChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange, //Hola se actualizara
        label = { Text("Introduce un texto") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun MyScreen(){
    //mutableStateOf inicializado con un booleano.
    var isChecked by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Este es el hijo porque esta recibiendo el estado del padre.
        /*
        isChecked => El estado,
        onTextChange => Funcion Callback
         */
        Text(
            text = "Modo Oscuro: ${if (isChecked) "Activado" else "Desactivado"}",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Funcion que permite cambiar el estado del padre.
        MySwitch(
            checked = isChecked, //Estado del padre True/False
            onCheckedChange = { isChecked = it } //Funcion Callback que permite cambiar el estado del padre
        )
    }
}

@Composable
fun MySwitch(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Switch(
        checked = checked, //Indica si estactivo o no
        onCheckedChange = onCheckedChange, //Funcion Callback que permite cambiar el estado del padre
        modifier = Modifier.padding(bottom = 16.dp),
        colors = SwitchDefaults.colors(
            checkedThumbColor = androidx.compose.ui.graphics.Color.Green, //Activo
            checkedTrackColor = androidx.compose.ui.graphics.Color.Red,
            uncheckedThumbColor = androidx.compose.ui.graphics.Color.Red, //Desactivo
            uncheckedTrackColor = androidx.compose.ui.graphics.Color.Green
        )
    )
}


