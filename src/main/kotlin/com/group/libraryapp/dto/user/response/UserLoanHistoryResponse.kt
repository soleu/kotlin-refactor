package com.group.libraryapp.dto.user.response

import com.group.libraryapp.dto.book.response.BookHistoryResponse

data class UserLoanHistoryResponse(
        val name: String, // 유저 이름
        val books: List<BookHistoryResponse>
)
