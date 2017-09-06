package com.smartextension.backend.rest

import com.smartextension.backend.datalayer.entities.Socket
import com.smartextension.backend.datalayer.repositories.ExtensionRepository
import com.smartextension.backend.datalayer.repositories.SocketRepository
import com.smartextension.backend.datalayer.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping(value = "/sockets")
open class SocketControler {

    @Suppress("MemberVisibilityCanPrivate")
    @Autowired
    lateinit var socketRepository: SocketRepository

    @Suppress("MemberVisibilityCanPrivate")
    @Autowired
    lateinit var extensionRepository: ExtensionRepository

    @Suppress("MemberVisibilityCanPrivate")
    @Autowired
    lateinit var userRepository: UserRepository

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAllSocket(): Collection<Socket> {
        return ArrayList<Socket>(socketRepository.findAll().toList())
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun addSocket(name: String, extensionId: Long): ResponseEntity<*> {
        if (name.isEmpty()) {
            return fieldCannotBeEmptyResponse("Name")
        }
        if (extensionRepository.findOne(extensionId) == null) {
            return ResponseEntity("Not found extension with id : $extensionId",
                    HttpStatus.NOT_FOUND)
        }

        val auth = SecurityContextHolder.getContext().authentication
        val user = userRepository.findByUsername(auth.name)
        user?.let {
            val socket = Socket(name = name, extensionId = extensionId, ownerId = it.id)
            socketRepository.save(socket)
            return ResponseEntity("Socket added", HttpStatus.CREATED)
        } ?: let {
            return ResponseEntity("UNAUTHORIZED", HttpStatus.UNAUTHORIZED)
        }
    }

}