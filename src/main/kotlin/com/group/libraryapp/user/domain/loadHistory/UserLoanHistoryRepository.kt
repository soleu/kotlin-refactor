package com.group.libraryapp.user.domain.loadHistory

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long> {
    fun findByBookNameAndIsReturn(bookName: String, isReturn: Boolean): UserLoanHistory?
}