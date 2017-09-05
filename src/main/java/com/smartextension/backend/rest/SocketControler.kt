package com.smartextension.backend.rest

import com.smartextension.backend.datalayer.entities.Socket
import com.smartextension.backend.datalayer.repositories.SocketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/sockets")
open class SocketControler {

    @Autowired
    lateinit var socketRepository: SocketRepository

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAllSocket(): Collection<Socket> {
        return ArrayList<Socket>(socketRepository.findAll().toList())
    }

}