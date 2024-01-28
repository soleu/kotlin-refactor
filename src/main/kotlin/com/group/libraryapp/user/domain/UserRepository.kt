package com.group.libraryapp.user.domain

import java.util.Optional
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): Optional<User>
}