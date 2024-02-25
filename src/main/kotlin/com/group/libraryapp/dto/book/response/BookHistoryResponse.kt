package com.group.libraryapp.dto.book.response

data class BookHistoryResponse(
        val name: String, // 책 이름
        val isReturn: Boolean
)