package com.example.cursojetpackcompose

import android.R.attr.top
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
fun MyTextview() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(
            state = rememberScrollState(),
            enabled = true
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        ReusableText(
            "Estrada Isaac",
            fontSize = 30.sp
        )

        ReusableText(
            "Developer",
            color = MaterialTheme.colorScheme.secondary
        )

        ReusableText(
            "https://github.com/estradaisaac",
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.fotoperfil),
        contentDescription = "Foto de perfil",
        modifier = Modifier.size(200.dp).clip(CircleShape).border(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary,
            shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyIcon(){
    Icon(
        imageVector = Icons.Default.Email,
        contentDescription = "Email",
        tint = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.size(60.dp).padding(16.dp)
    )
}

@Composable
fun MyCanva(){
    val backgroundColor = MaterialTheme.colorScheme.primary

    Canvas(
        modifier = Modifier.size(300.dp).padding(16.dp)
    ) {
        drawCircle(
            color = backgroundColor,
            radius = size.minDimension/4
        )
    }
}

@Composable
fun MyHelpers() {
    HorizontalDivider(
        color = MaterialTheme.colorScheme.primary,
        thickness = 2.dp,
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
    )

    Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))
}

@Composable
fun MyButtons(){
    Button(
        onClick = { /*TODO*/ },
        colors= ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite"
        )

        Text("Like")
    }

    Spacer(modifier = Modifier.fillMaxWidth().height(5.dp))

    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.shadow(4.dp, RoundedCornerShape(10.dp))
    ) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )

        Text("Like")
    }


    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text("Ir al enlace")
    }

}

@Composable
fun MyProgressIndicators(){
    CircularProgressIndicator(
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = 2.dp,
        modifier = Modifier.size(60.dp).padding(16.dp)
    )

    LinearProgressIndicator(
        color = MaterialTheme.colorScheme.primary,
        trackColor = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
    )
}

@Composable
fun MyColumn(){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, /* CenterHorizontally Start, End */
        verticalArrangement = Arrangement.Center /*Center Top, Bottom, SpaceBetween, SpaceAround, SpaceEvenly */
    ){
        Image(
            painter = painterResource(id = R.drawable.fotoperfil),
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(200.dp).clip(CircleShape).border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))

        ReusableText(
            "https://github.com/estradaisaac",
            color = MaterialTheme.colorScheme.tertiary
        )

        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))

        Button(
            onClick = { /*TODO*/ },
            colors= ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )

            Text("Like")
        }
    }
}

@Composable
fun MyRow(){
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.Center, /* Start, End, Center, SpaceBetween, SpaceAround, SpaceEvenly, Absolute */
        verticalAlignment = Alignment.CenterVertically /*Top, Bottom, CenterVertically */
    ){
        Button(
            onClick = { /*TODO*/ },
            colors= ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite"
            )

            Text("Like")
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.shadow(4.dp, RoundedCornerShape(10.dp))
        ) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )

            Text("Like")
        }


        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                contentColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Ir al enlace")
        }
    }
}

@Composable
fun MyBox(){
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center /*Todos los hijos heredan la alineación*/
    ){
        Image(
            painter = painterResource(id = R.drawable.colors),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Text(
            text = "Estrada Isaac",
            style = TextStyle(
                color = Color.White,
                fontSize = 30.sp
            )
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            colors= ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("Example")
        }
    }
}


@Composable
fun MyConstraintLayout(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ){
        val (image, name, button, description) = createRefs()


        Image(
            painter = painterResource(id = R.drawable.fotoperfil),
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Estrada Isaac",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(image.top)
                start.linkTo(image.end, margin = 16.dp)

            }
        )

        Text(
            "Android Developer",
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.constrainAs(description) {
                top.linkTo(name.bottom, margin = 4.dp)
                start.linkTo(name.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints /* Ocupa todo el ancho disponible*/
            }
        )


        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(description.bottom, margin = 4.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text("Contactar")
        }
    }
}


@Composable
fun Components(){
    MyConstraintLayout()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Components()
}