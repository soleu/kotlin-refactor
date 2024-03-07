package com.group.libraryapp.repository.user.loanHistory

import com.group.libraryapp.domain.user.loadHistory.QUserLoanHistory.userLoanHistory
import com.group.libraryapp.domain.user.loadHistory.UserLoanHistory
import com.group.libraryapp.domain.user.loadHistory.UserLoanStatus
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class UserLoanHistoryQuerydslRepository(
        private val queryFactory: JPAQueryFactory,
) {
    // findByBookName
    // findByBookNameAndStatus
    fun find(bookName: String, status: UserLoanStatus? = null): UserLoanHistory? {
        return queryFactory.select(userLoanHistory)
                .from(userLoanHistory)
                .where(userLoanHistory.bookName.eq(bookName),
                        // status 가 있을 때만 필터
                        status?.let { userLoanHistory.status.eq(status) }
                )
                .limit(1)
                .fetchOne()
    }

    fun count(status: UserLoanStatus): Long {
        return queryFactory.select(userLoanHistory.id.count())
                .from(userLoanHistory)
                .where(userLoanHistory.status.eq(status))
                .fetchOne() ?: 0L // fetchOne 은 null 이 나올 수 있음
    }
}