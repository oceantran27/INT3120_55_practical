package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class BookList(
    val kind: String,
    val totalItems: Int,
    val items: List<BookItem>
)

@Serializable
data class BookItem(
    val kind: String,
    val id: String,
    val etag: String,
    val selfLink: String,
    val volumeInfo: BookInfo
)

@Serializable
data class BookInfo(
    val title: String,
    val authors: List<String>,
    val publisher: String,
    val publishedDate: String,
    val description: String,
    val imageLinks: ImageLinks
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)