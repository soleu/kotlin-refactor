package com.group.libraryapp.controller.book

import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import com.group.libraryapp.dto.book.response.BookStatResponse
import com.group.libraryapp.service.book.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * controller 설계법 3가지
 * 1. 화면에서 사용되는 API 끼리 모으기
 * 장 : 화면에서 사용되는 API 찾기 용이, 단 : 한 API가 여려 화면에서 사용된다면 위치 애매, 서버 코드가 화면에 종속적
 *
 * 2. 동일한 도메인끼리 API 모으기
 * 장 : 코드 위치 예측 가능 단 : 어디서 사용되는지 보기 어려움
 *
 * 3. 1 API 1 Controller
 * 음...
 * '프로젝트가 낯선 사람 입장에서 어떤 기능에 대한 코드가 어디에 있는가'
 */
@RestController
class BookController(
        private val bookService: BookService,
) {
    @PostMapping("/book")
    fun saveBook(@RequestBody request: BookRequest) {
        bookService.saveBook(request)
    }

    @PostMapping("book/loan")
    fun loanBook(@RequestBody request: BookLoanRequest) {
        bookService.loanBook(request)
    }

    @PutMapping("/book/return")
    fun returnBook(@RequestBody request: BookReturnRequest) {
        bookService.returnBook(request)
    }

    @GetMapping("/book/loan")
    fun countLoanBook(): Int {
        return bookService.countLoanBook()
    }

    @GetMapping("/book/stat")
    fun getBookStatistics(): List<BookStatResponse> {
        return bookService.getBookStatistics()
    }
}