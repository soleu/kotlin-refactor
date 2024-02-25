package com.group.libraryapp.domain.book

import java.lang.IllegalArgumentException
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book(
        val name: String,

        @Enumerated(EnumType.STRING)
        val type: BookType,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다")
        }
    }

    companion object {
        /**
         * 정적 팩토리 메소드
         * 테스트를 위한 메소드
         */
        fun fixture(
                name: String = "이상한 나라의 앨리스",
                type: BookType = BookType.COMPUTER,
                id: Long? = null
        ): Book {
            return Book(name = name, type = type, id = id)
        }
    }
}