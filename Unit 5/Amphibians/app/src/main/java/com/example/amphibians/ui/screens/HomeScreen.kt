package com.example.amphibians.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.model.AmphibianItem
import com.example.amphibians.ui.theme.AmphibiansTheme
import kotlin.math.log

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier,
    retryAction: () -> Unit
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier.size(200.dp))
        is AmphibiansUiState.Success -> {
            AmphibiansListScreen(amphibians = amphibiansUiState.amphibians, modifier = modifier.padding(0.dp))}
        else -> ErrorScreen(retryAction, modifier)
    }
}

@Composable
private fun AmphibiansListScreen(
    amphibians: List<AmphibianItem>,
    modifier: Modifier = Modifier.fillMaxSize().border(2.dp, color = Color.Blue),
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Text(text = "Size: ${amphibians.size}", style = MaterialTheme.typography.bodyMedium)
    Log.d("OCEANNNNNNN", "${amphibians.size}")
}

@Composable
fun AmphibianCard(amphibian: AmphibianItem, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {  }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading",
        modifier = modifier
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Error Screen")
        Button(onClick = retryAction) {
            Text("Retry")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    AmphibiansTheme() {
        LoadingScreen(modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    AmphibiansTheme() {
        ErrorScreen({}, modifier = Modifier.fillMaxSize())
    }
}