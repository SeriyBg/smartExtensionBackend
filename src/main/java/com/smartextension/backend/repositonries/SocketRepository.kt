package com.smartextension.backend.repositonries

import com.smartextension.backend.entities.Socket
import org.springframework.data.repository.CrudRepository

interface SocketRepository : CrudRepository<Socket, Long>