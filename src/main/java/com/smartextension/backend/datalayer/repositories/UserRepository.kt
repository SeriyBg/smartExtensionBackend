package com.smartextension.backend.datalayer.repositories

import com.smartextension.backend.datalayer.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findOneByUsername(username: String): User?

}
