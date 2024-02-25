package com.group.libraryapp.dto.book.response

import com.group.libraryapp.domain.user.loadHistory.UserLoanHistory
import com.group.libraryapp.domain.user.loadHistory.UserLoanStatus

data class BookHistoryResponse(
        val name: String, // 책 이름
        val isReturn: Boolean
) {
    companion object {
        fun of(history: UserLoanHistory): BookHistoryResponse {
            return BookHistoryResponse(
                    name = history.bookName,
                    isReturn = history.isReturn
            )
        }
    }
}