package com.smartextension.backend.database

import com.smartextension.backend.entities.Socket
import com.smartextension.backend.entities.User
import com.smartextension.backend.repositonries.SocketRepository
import com.smartextension.backend.repositonries.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataBaseLoader @Autowired constructor(
        @Suppress("MemberVisibilityCanPrivate") var sockets: SocketRepository,
        @Suppress("MemberVisibilityCanPrivate") var users: UserRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val socketList = mutableListOf(Socket("name 1"), Socket("name 2"), Socket("name 3"))
        sockets.save(socketList)

        val students = mutableListOf(
                User("firtsName1", "lastName1", "username1", "pass",
                        arrayOf("ROLE_USER")),
                User("firtsName2", "lastName2", "username2", "pass",
                        arrayOf("ROLE_USER")),
                User("firtsName3", "lastName3", "username3", "123456",
                        arrayOf("ROLE_USER", "ROLE_ADMIN"))
        )
        users.save(students)
    }

}