package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.dto.book.response.BookHistoryResponse

data class UserLoanHistoryResponse(
        val name: String, // 유저 이름
        val books: List<BookHistoryResponse>
) {
    companion object {
        fun of(user: User): UserLoanHistoryResponse {
            return UserLoanHistoryResponse(
                    name = user.name,
                    books = user.userLoanHistories.map(BookHistoryResponse::of))
        }
    }
}
