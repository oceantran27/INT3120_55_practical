package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsTheme {
                Surface {
                    ComposeQuadrant(Modifier.statusBarsPadding())
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background);

    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = "Jetpack Compose tutorial",
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp,
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()) {
        val image = painterResource(R.drawable.ic_task_completed);
        Image(
            painter = image,
            contentDescription = null,
        )
        Text (
            text = "All tasks completed",
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold,
        )
        Text (
            text = "Nice work!",
            fontSize = 16.sp,
        )
    }
}

@Composable
fun ComposeQuadrant(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row (modifier = modifier.weight(1f).fillMaxWidth()) {
            Box(modifier = modifier.weight(1f).background(Color(0xFFEADDFF)).fillMaxSize().padding(16.dp)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
                    Text(
                        text = "Text composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Displays text and follows the recommended Material Design guidelines.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Box(modifier = modifier.weight(1f).background(Color(0xFFD0BCFF)).fillMaxSize().padding(16.dp)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
                    Text(
                        text = "Image composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
        Row (modifier = modifier.weight(1f).fillMaxWidth()) {
            Box(modifier = modifier.weight(1f).background(Color(0xFFB69DF8)).fillMaxSize().padding(16.dp)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
                    Text(
                        text = "Row composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "A layout composable that places its children in a horizontal sequence.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Box(modifier = modifier.weight(1f).background(Color(0xFFF6EDFF)).fillMaxSize().padding(16.dp)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
                    Text(
                        text = "Column composable",
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = "A layout composable that places its children in a vertical sequence.",
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}