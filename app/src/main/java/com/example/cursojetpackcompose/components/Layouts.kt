package com.example.cursojetpackcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.cursojetpackcompose.R

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
fun MyLazyColumn(){
    val itemList = List(10){"Element N: $it"} /*Me genera una lista de 100 elementos*/

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){

        //Funcion que se ejecuta una vez para generar el header de la lista
        item{
            Text(
                text = "Header de mi lista",
                style = MaterialTheme.typography.titleLarge
            )
        }

        //Esta funcion viene con lazycolumn, nos devuelve una funcion anonima cada vez que itera sobre la lista
        items(itemList){ element ->
            Text(
                text = element
            )
        }

        //Funcion que se ejecuta una vez para generar el header de la lista
        item{
            Text(
                text = "Footer de mi lista",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
fun MyLazyRowWithText(){
    val itemList = List(100){"Element N: $it"} /*Me genera una lista de 100 elementos*/

    LazyRow(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(itemList){ element ->
            Card(
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = element
                    )
                }
            }
        }
    }


}

@Composable
fun MyLazyRowWithImage(){
    val listImages = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp) //Distancia entre elementos
    ) {
        items(listImages) { image ->
            Card(
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(10.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "Image de paisaje",
                        modifier = Modifier.size(100.dp).clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = image.toString(),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun MyLazyRowWithImageWeb(){
    val listImageUrls = listOf(
        "https://cdn.pixabay.com/photo/2016/05/25/13/55/horses-1414889_960_720.jpg",
        "https://cdn.pixabay.com/photo/2015/04/10/01/41/fox-715588_960_720.jpg",
        "https://cdn.pixabay.com/photo/2023/01/10/16/23/hedgehog-7710053_960_720.jpg",
        "https://cdn.pixabay.com/photo/2016/05/25/13/55/horses-1414889_1280.jpg",
        "https://cdn.pixabay.com/photo/2021/04/05/14/54/meerkats-6153748_960_720.jpg",
        "https://cdn.pixabay.com/photo/2021/05/14/21/49/elephants-6254556_960_720.jpg",
        "https://cdn.pixabay.com/photo/2021/04/30/14/53/deer-6219100_960_720.jpg",
        "https://cdn.pixabay.com/photo/2020/02/11/09/22/bear-4838870_960_720.jpg",
        "https://cdn.pixabay.com/photo/2018/05/24/17/35/parrots-3427188_960_720.jpg",
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp) //Distancia entre elementos
    ) {
        items(listImageUrls) { imageUrl ->
            Card(
                modifier = Modifier.size(100.dp),
                shape = RoundedCornerShape(10.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(4.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    //Asyncono porque descarga las imagenes desde un hilo por detras del hilo principal
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = "Image de paisaje",
                        modifier = Modifier.size(100.dp).clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = imageUrl.toString(),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun MyLazyVerticalGrid(){
    val elements = List(20){"Element N: ${it +1}"} /*Me genera una lista de 20 elementos*/

    LazyVerticalGrid(
        //columns = GridCells.Adaptive(120.dp), //Columnas de 120dp establecidas como ancho minimo que debe de tener una celda (variable con el ancho minimo de la celda)
        columns = GridCells.Fixed(2), //Celdas fijas
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(elements){ myCurrentElement ->
            //Esta funcion es personalizada a la cual le paso las lista de elementos para renderizarlos en la vista
            GridItem(element = myCurrentElement)
        }
    }
}


@Composable
fun MyLazyHorizontalGrid(){
    val elements = List(20){"Element N: ${it +1}"} /*Me genera una lista de 20 elementos*/

    LazyHorizontalGrid(
        rows = GridCells.Adaptive(100.dp), //Adaptative hace referencia a la altura
        //rows = GridCells.Fixed(4), //Celdas fijas (Filas)
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(elements){ myCurrentElement ->
            //Esta funcion es personalizada a la cual le paso las lista de elementos para renderizarlos en la vista
            GridItemHorizontal(element = myCurrentElement)
        }
    }
}

@Composable
fun GridItemHorizontal(element: String) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(120.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(
                color = MaterialTheme.colorScheme.primaryContainer
            )
            .border(
                2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center

    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = element,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}


@Composable
fun GridItem(element: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center

    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Cell icon",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = element,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}