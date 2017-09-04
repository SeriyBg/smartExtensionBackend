package com.smartextension.backend.repositonries

import com.smartextension.backend.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(userName : String) : User?

}
