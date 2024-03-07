package com.group.libraryapp.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Long>, UserRepositoryCustom {
    fun findByName(name: String): User?

    /**
     * fetch 를 안 작성하면, 결국 쿼리는 따로 나가게됨
     * 가져온 값을 넣어주는 과정까지 실행되므로
     */
//    @Query("select DISTINCT u from User u LEFT JOIN FETCH u.userLoanHistories")
//    fun findAllWithHistories(): List<User>
}