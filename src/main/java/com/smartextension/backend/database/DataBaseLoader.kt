package com.smartextension.backend.database

import com.smartextension.backend.entities.Socket
import com.smartextension.backend.repositonries.SocketRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataBaseLoader @Autowired constructor(var sockets: SocketRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val socketList = mutableListOf(Socket("name 1"), Socket("name 2"), Socket("name 3"))
        sockets.save(socketList)
    }

}