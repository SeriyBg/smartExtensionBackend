package com.smartextension.backend.rest

import com.smartextension.backend.datalayer.entities.Socket
import com.smartextension.backend.datalayer.repositories.ExtensionRepository
import com.smartextension.backend.datalayer.repositories.SocketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/sockets")
open class SocketControler {

    @Autowired
    lateinit var socketRepository: SocketRepository

    @Autowired
    lateinit var extensionRepository: ExtensionRepository

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAllSocket(): Collection<Socket> {
        return ArrayList<Socket>(socketRepository.findAll().toList())
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun addSocket(name: String, extensionId: Long): ResponseEntity<*> {
        if (name.isEmpty()) {
            return ResponseEntity("Name cannot be empty", HttpStatus.BAD_REQUEST)
        }
        if (extensionRepository.findOne(extensionId) == null) {
            return ResponseEntity("Not found extension with id : $extensionId",
                    HttpStatus.NOT_FOUND)
        }

        val socket = Socket(name, extensionId)
        socketRepository.save(socket)
        return ResponseEntity("Socket added", HttpStatus.CREATED)
    }

}