package com.example.artspace

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface() {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    val maxWidth = 300.dp
    var count: Int by remember{mutableStateOf(0)}
    Column(
        modifier = modifier.safeContentPadding()
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        val layoutModifier = Modifier
        Spacer(modifier = Modifier.height(15.dp).fillMaxWidth())
        Box (modifier = Modifier.wrapContentSize().shadow(elevation = 3.dp)) {
            Box(
                modifier = layoutModifier.padding(28.dp).height(400.dp).width(maxWidth).background(Color.White)
            ) {
                var painterRes = R.drawable.default_image
                if (count == 0) {
                    painterRes = R.drawable.first
                } else if (count == 1) {
                    painterRes = R.drawable.second
                } else {
                    painterRes = R.drawable.third
                }
                Image(
                    painter = painterResource(painterRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp).fillMaxWidth())
        Box (modifier = Modifier.wrapContentSize().background(Color(0xFFECEBF0))) {
            Box(
                modifier = layoutModifier.padding(14.dp).width(maxWidth).wrapContentHeight(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.wrapContentSize().fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    var title:Int? = null
                    var artist:Int? = null
                    var year: Int? = null

                    if (count == 0) {
                        title = R.string.first_title
                        artist = R.string.first_artist
                        year = R.string.first_year
                    } else if (count == 1) {
                        title = R.string.second_title
                        artist = R.string.second_artist
                        year = R.string.second_year
                    } else {
                        title = R.string.third_title
                        artist = R.string.third_artist
                        year = R.string.third_year
                    }
                    Text(
                        text = stringResource(title),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Light,
                    )
                    Row() {
                        Text(
                            fontSize = 16.sp,
                            text = stringResource(artist),
                            fontWeight = FontWeight.Black
                        )
                        Text(
                            text = "(" + stringResource(year) + ")",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light,
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp).fillMaxWidth())
        Box(
            modifier = layoutModifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp).fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {count = (count - 1) % 3},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF535D77)
                    )
                ) {
                    Text(text = "Previous")
                }
                Button(
                    onClick = {count = (count + 1) % 3},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF535D77)
                    )
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceReview() {
    ArtSpaceApp()
}