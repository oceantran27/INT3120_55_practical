package com.example.buildagrid

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.example.buildagrid.model.Topic
import com.example.buildagrid.ui.theme.BuildAGridTheme

val topic1 = Topic(R.string.architecture, 58, R.drawable.architecture)
val topic2 = Topic(R.string.crafts, 121, R.drawable.crafts)
val topic3 = Topic(R.string.business, 78, R.drawable.business)
val topic4 = Topic(R.string.culinary, 118, R.drawable.culinary)
val topic5 = Topic(R.string.design, 423, R.drawable.design)
val topic6 = Topic(R.string.fashion, 92, R.drawable.fashion)
val topic7 = Topic(R.string.film, 165, R.drawable.film)
val topic8 = Topic(R.string.gaming, 164, R.drawable.gaming)
val topic9 = Topic(R.string.drawing, 326, R.drawable.drawing)
val topic10 = Topic(R.string.lifestyle, 305, R.drawable.lifestyle)
val topic11 = Topic(R.string.music, 212, R.drawable.music)
val topic12 = Topic(R.string.painting, 172, R.drawable.painting)
val topic13 = Topic(R.string.photography, 321, R.drawable.photography)
val topic14 = Topic(R.string.tech, 118, R.drawable.tech)
val topics = List(20) { index ->
    when (index) {
        0 -> topic1
        1 -> topic2
        2 -> topic3
        3 -> topic4
        4 -> topic5
        5 -> topic6
        6 -> topic7
        7 -> topic8
        8 -> topic9
        9 -> topic10
        10 -> topic11
        11 -> topic12
        12 -> topic13
        13 -> topic14
        14 -> topic1
        15 -> topic2
        16 -> topic3
        17 -> topic4
        18 -> topic5
        19 -> topic6
        else -> topic1
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseApp()
        }
    }
}

@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    val painter = painterResource(topic.imageRes)
    Card(
        modifier = Modifier.width(108.dp).height(68.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color(0xFFE4E1E6))
    ) {
        val defaultModifier = Modifier.fillMaxSize()
        Row(modifier = defaultModifier) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.width(68.dp).height(68.dp)
            )
            Surface(
                modifier = defaultModifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                color = Color.Transparent
            ) {
                Column(modifier = defaultModifier) {
                    Text(
                        text = stringResource(topic.name),
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Row(
                        modifier = defaultModifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.fillMaxHeight().aspectRatio(1f)
                        )
                        Text(
                            text = topic.availableCourses.toString(),
                            modifier = Modifier.padding(start = 8.dp),
                            style = MaterialTheme.typography.labelMedium,
                            fontSize = 12.sp,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CourseApp(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(topics) { topic ->
            CourseCard(topic)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CourseApp()
}