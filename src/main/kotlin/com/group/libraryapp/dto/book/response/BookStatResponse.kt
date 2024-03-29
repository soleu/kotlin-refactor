package com.group.libraryapp.dto.book.response

import com.group.libraryapp.domain.book.BookType

data class BookStatResponse(
        var count: Long,
        val type: BookType
) {
    fun plusOne() {
        count++
    }
}