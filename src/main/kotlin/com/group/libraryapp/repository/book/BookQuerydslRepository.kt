package com.group.libraryapp.repository.book

import com.group.libraryapp.domain.book.QBook.book
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Component

@Component
class BookQuerydslRepository(
        private val queryFactory: JPAQueryFactory,
) {
//    @Query("SELECT NEW com.group.libraryapp.dto.book.response.BookStatResponse(COUNT(b.id),b.type)" +
//            " FROM Book b GROUP BY b.type")
    fun getStats(): List<BookStatResponse> {
        // projection : 모두 가져오는게 아닌 특정 칼럼만 가져오겠다.
        return queryFactory.select(Projections.constructor(
                BookStatResponse::class.java, // 가져올 대상
                book.type, // 생성자로 차례로 들어가게 됨
                book.id.count()
        ))
                .from(book)
                .groupBy(book.type)
                .fetch()
    }
}