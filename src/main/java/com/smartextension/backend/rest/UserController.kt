package com.smartextension.backend.rest

import com.smartextension.backend.datalayer.entities.User
import com.smartextension.backend.datalayer.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/user")
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun signUpUser(name: String, password: String): ResponseEntity<*> {
        val user = User()
        user.setPassword(password)
        user.setUserName(name)

        val savedUser = userRepository.save(user)
        return ResponseEntity(savedUser, HttpStatus.OK)
    }
}