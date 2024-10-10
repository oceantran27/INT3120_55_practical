package com.example.bookshelf.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.model.BookItem
import com.example.bookshelf.model.BookList
import com.example.bookshelf.ui.theme.BookShelfTheme
import kotlin.math.log

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen(modifier.size(200.dp))
        is BooksUiState.Success ->
            BooksListScreen(
                bookList = booksUiState.bookList,
                modifier = modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    ),
                contentPadding = contentPadding
            )
        else -> ErrorScreen(retryAction, modifier)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading),
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
        Text(stringResource(R.string.loading_failed))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

//@Composable
//fun BookCard(bookItem: BookItem, modifier: Modifier = Modifier) {
//    Card(
//        modifier = modifier,
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//            Text(
//                text = stringResource(R.string.amphibian_title, amphibian.name, amphibian.type),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(dimensionResource(R.dimen.padding_medium)),
//                style = MaterialTheme.typography.titleLarge,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Start
//            )
//            AsyncImage(
//                modifier = Modifier.fillMaxWidth(),
//                model = ImageRequest.Builder(context = LocalContext.current)
//                    .data(amphibian.imgSrc)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = null,
//                contentScale = ContentScale.FillWidth,
//                error = painterResource(id = R.drawable.ic_broken_image),
//                placeholder = painterResource(id = R.drawable.loading_img)
//            )
//            Text(
//                text = amphibian.description,
//                style = MaterialTheme.typography.titleMedium,
//                textAlign = TextAlign.Justify,
//                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
//            )
//        }
//    }
//}

@Composable
private fun BooksListScreen(
    bookList: BookList,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Log.d("Oceannnnnnnn", "${bookList.kind}")
    Column(modifier = Modifier.fillMaxSize().padding(contentPadding)) {
        Text(
            text = bookList.kind,
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, color = Color.Blue),
            color = Color.Black,
            fontSize = 20.sp
        )
        Text("Do sthing please")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LoadingScreenPreview() {
//    AmphibiansTheme {
//        LoadingScreen(
//            Modifier
//                .fillMaxSize()
//                .size(200.dp)
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ErrorScreenPreview() {
//    AmphibiansTheme {
//        ErrorScreen({}, Modifier.fillMaxSize())
//    }
//}
//
@Preview(showBackground = true)
@Composable
fun AmphibiansListScreenPreview() {
    BookShelfTheme() {
        val mockData =
            BookList(
                "programming",
                27,
                emptyList<BookItem>(),
            )
        BooksListScreen(mockData, Modifier.fillMaxSize())
    }
}