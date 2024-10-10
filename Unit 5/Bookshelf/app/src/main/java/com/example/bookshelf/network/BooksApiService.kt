package com.example.bookshelf.network

import com.example.bookshelf.model.BookList
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun getBookList(@Query("q") query: String): BookList
}