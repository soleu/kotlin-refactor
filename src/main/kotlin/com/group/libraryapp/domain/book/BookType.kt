package com.group.libraryapp.domain.book

/**
 * 1. DB의 어떤 값이 들어갈지 미리 알 수 있음
 * 2. 별도의 검증 로직 없이도 오타 해결
 * 3. 코드의 확장시, 분기 처리 없음 / 수정시 빠지지 않음
 */
enum class BookType {
    COMPUTER,
    ECONOMY,
    LANGUAGE,
    SOCIETY,
    SCIENCE
}