package com.group.libraryapp.dto.user.response

import com.group.libraryapp.domain.user.User

data class UserResponse(
        val id: Long,
        val name: String,
        val age: Int?,
) {
    companion object { // 생성자 -> 정적 팩토리
        fun of(user: User): UserResponse {
            return UserResponse(
                    id = user.id!!,
                    name = user.name,
                    age = user.age
            )
        }
    }
}
