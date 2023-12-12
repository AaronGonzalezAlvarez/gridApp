package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridapp.data.DataSource
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().padding(4.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    gridApp(DataSource.topics)
                }
            }
        }
    }
}

@Composable
fun gridApp(topics:List<Topic>) {
    LazyVerticalGrid(
        modifier= Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding= PaddingValues(2.dp),
        content = {
            items(topics) { topics ->
                tipocCard(topics)
            }
        }
    )
}

@Composable
fun tipocCard(topic: Topic, modifer: Modifier = Modifier){
    Card(
        modifier = modifer.fillMaxSize().background(Color.Magenta).padding(2.dp)
    ) {
        Row (
        ){
            Image(
                modifier= Modifier.fillMaxHeight(),
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = topic.stringResourceId),
                    fontSize = 15.sp
                )
                Row (
                ){
                    Text(
                        text = topic.num.toString(),
                        modifier = Modifier.padding(start = 3.dp, end = 3.dp)
                    )
                    Text(
                        text = "0"
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GridAppTheme {
        tipocCard(DataSource.topics.get(0))
    }
}