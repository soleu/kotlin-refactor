package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.user.loadHistory.UserLoanHistory
import com.group.libraryapp.domain.user.loadHistory.UserLoanStatus
import java.lang.IllegalArgumentException
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class User(

        var name: String,

        val age: Int?,

        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
        val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(),


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다")
        }
    }

    fun updateName(name: String) {
        this.name = name
    }

    fun loanBook(book: Book) {
        this.userLoanHistories.add(UserLoanHistory(this, book.name, UserLoanStatus.LOANED, null))
    }

    fun returnBook(bookName: String) {
        return this.userLoanHistories
                .first() { history ->
                    history.bookName == bookName
                }.doReturn()
    }
}