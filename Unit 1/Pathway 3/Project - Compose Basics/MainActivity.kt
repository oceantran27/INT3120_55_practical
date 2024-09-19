package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
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
import com.example.businesscard.ui.theme.BusinessCardTheme


val backgroundColor = Color(android.graphics.Color.parseColor("#DAE5DB"))
val backgroundLogoColor = Color(android.graphics.Color.parseColor("#182C35"))
val logoColor = Color(android.graphics.Color.parseColor("#296047"))
val sloganColor = Color(android.graphics.Color.parseColor("#285D42"))


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize().background(backgroundColor)) {
                    Greeting(
                        modifier = Modifier.background(backgroundColor)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Column(
        modifier = modifier.padding(16.dp).fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.width(120.dp).background(backgroundLogoColor)
                    .fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Jennifer Doe",
                fontSize = 42.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                color = sloganColor
            )
        }
        Spacer(modifier = Modifier.height(128.dp))
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Row() {
                Icon(
                    imageVector = Icons.Filled.Call,
                    tint = logoColor,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp),
                )
                Text(
                    text = "+11 (123) 444 555 666",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Row() {
                Icon(
                    imageVector = Icons.Filled.Share,
                    tint = logoColor,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp),
                )
                Text(
                    text = "@AndroidDev",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Row() {
                Icon(
                    imageVector = Icons.Filled.Email,
                    tint = logoColor,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp),
                )
                Text(
                    text = "jen.doe@android.com",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
