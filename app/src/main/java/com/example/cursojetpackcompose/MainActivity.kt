package com.example.cursojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cursojetpackcompose.states.CounterScreen
import com.example.cursojetpackcompose.states.MyDerivedState
import com.example.cursojetpackcompose.states.MyScreen
import com.example.cursojetpackcompose.ui.theme.CursoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoJetpackComposeTheme {
                Components()
            }
        }
    }
}

@Composable
fun Components(){
    MyDerivedState()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Components()
}