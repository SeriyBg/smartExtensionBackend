package com.smartextension.backend.rest

import com.smartextension.backend.datalayer.entities.User
import com.smartextension.backend.datalayer.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class Initlizer : ApplicationRunner {

    @Autowired
    lateinit var users : UserRepository

    override fun run(args: ApplicationArguments?) {
        val user = User()
        user.username = "user2"
        user.setNewPassword("12345")
        user.role = "ROLE_USER"
        users.save(user)
    }
}