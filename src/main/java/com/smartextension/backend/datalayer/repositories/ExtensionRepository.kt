package com.smartextension.backend.datalayer.repositories

import com.smartextension.backend.datalayer.entities.Extension
import org.springframework.data.jpa.repository.JpaRepository

interface ExtensionRepository : JpaRepository<Extension, Long>