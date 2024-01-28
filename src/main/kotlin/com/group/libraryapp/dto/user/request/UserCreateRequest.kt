package com.group.libraryapp.dto.user.request

data class UserCreateRequest(val name: String, // 이걸 통해 코틀린에서 타입 확인 가능
                        val age: Int?)
