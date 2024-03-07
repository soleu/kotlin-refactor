package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.user.QUser.user
import com.group.libraryapp.domain.user.loadHistory.QUserLoanHistory.userLoanHistory
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRepositoryCustomImpl(
        private val queryFactory: JPAQueryFactory,
) : UserRepositoryCustom {

    // @Query("select DISTINCT u from User u LEFT JOIN FETCH u.userLoanHistories")
    override fun findAllWithHistories(): List<User> {
        return queryFactory.select(user).distinct()
                .from(user)
                .leftJoin(userLoanHistory).on(userLoanHistory.user.id.eq(user.id)).fetchJoin()
                // 앞에 조인을 패치 조인으로 간주한다
                .fetch()
    }
}