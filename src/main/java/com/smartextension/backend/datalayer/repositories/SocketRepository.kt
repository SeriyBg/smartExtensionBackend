package com.smartextension.backend.datalayer.repositories

import com.smartextension.backend.datalayer.entities.Socket
import org.springframework.data.jpa.repository.JpaRepository

interface SocketRepository : JpaRepository<Socket, Long>