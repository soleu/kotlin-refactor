package com.group.libraryapp.domain.book

import java.util.Optional
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
    fun findByName(bookName: String): Book?// 코틀린에서는 Optional이 꼭 필요하지는 않음
}