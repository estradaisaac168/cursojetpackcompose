package com.example.cursojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cursojetpackcompose.SecondaryEffect.UserDataScreen
import com.example.cursojetpackcompose.seccion15.BottomAppBar
import com.example.cursojetpackcompose.seccion15.CenterAlignedTopBar
import com.example.cursojetpackcompose.seccion15.ExtendedFloatingActionButton
import com.example.cursojetpackcompose.seccion15.FloatingActionButton
import com.example.cursojetpackcompose.seccion15.MyScaffoldScreen
import com.example.cursojetpackcompose.seccion15.NavigationBar
import com.example.cursojetpackcompose.seccion15.NavigationDrawer
import com.example.cursojetpackcompose.seccion15.NavigationRail
import com.example.cursojetpackcompose.seccion15.PaddingValues
import com.example.cursojetpackcompose.seccion15.ScaffoldScreenTopAppBar
import com.example.cursojetpackcompose.seccion15.ScrollTabRow
import com.example.cursojetpackcompose.seccion15.TabRow
import com.example.cursojetpackcompose.states.CounterLifeCycle
import com.example.cursojetpackcompose.states.CounterScreen
import com.example.cursojetpackcompose.states.MutableStateListOf
import com.example.cursojetpackcompose.states.MutableStateListOfSaver
import com.example.cursojetpackcompose.states.MutableStateMapOf
import com.example.cursojetpackcompose.states.MyDerivedState
import com.example.cursojetpackcompose.states.MyScreen
import com.example.cursojetpackcompose.states.Recomposition
import com.example.cursojetpackcompose.states.TaskListScreen
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
    ScrollTabRow()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Components()
}