package com.group.libraryapp.domain.book

import com.group.libraryapp.dto.book.response.BookStatResponse
import java.util.Optional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BookRepository : JpaRepository<Book, Long> {
    fun findByName(bookName: String): Book?// 코틀린에서는 Optional이 꼭 필요하지는 않음
    //  query에서 받는 숫자는 항상 Long Type
    // New를 사용하면 특정 dto로 바로 변환 가능
    @Query("SELECT NEW com.group.libraryapp.dto.book.response.BookStatResponse(COUNT(b.id),b.type)" +
            " FROM Book b GROUP BY b.type")
    fun getStats(): List<BookStatResponse>
}