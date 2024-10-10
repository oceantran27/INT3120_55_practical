package com.example.bookshelf.data

import com.example.bookshelf.model.BookList
import com.example.bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBookList(): BookList
}

class DefaultBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {
    override suspend fun getBookList(): BookList = booksApiService.getBookList("programming")
}