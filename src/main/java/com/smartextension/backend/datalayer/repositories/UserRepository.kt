package com.smartextension.backend.datalayer.repositories

import com.smartextension.backend.datalayer.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {

    fun findByUsername(userName : String) : User?

}
