package com.smartextension.backend.datalayer.repositories

import com.smartextension.backend.datalayer.entities.Socket
import org.springframework.data.repository.CrudRepository

interface SocketRepository : CrudRepository<Socket, Long>