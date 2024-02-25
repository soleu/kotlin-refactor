package com.group.libraryapp.domain.user.loadHistory

import com.group.libraryapp.domain.user.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne


@Entity
class UserLoanHistory(
        @ManyToOne
        val user: User,

        val bookName: String,

        var status: UserLoanStatus = UserLoanStatus.LOANED, // boolean도 enum으로 바꿀 때가 좋을 수 있음
        /**
         * Boolean이 2개 이상되면 문제가 생길 수 있음
         * 1. 한 객체의 성질을 표현할 필드가 여러개가 됨
         * 2. 경우의 수로 만들어지는 값들이 유의미하지 않음
         */

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
) {
    fun doReturn() {
        this.status = UserLoanStatus.RETURNED
    }

    companion object {
        fun fixture(
                user: User,
                bookName: String = "이상한 나라의 앨리스",
                status: UserLoanStatus = UserLoanStatus.LOANED,
                id: Long? = null
        ): UserLoanHistory {
            return UserLoanHistory(
                    user = user,
                    bookName = bookName,
                    status = status,
                    id = id
            )
        }
    }
}