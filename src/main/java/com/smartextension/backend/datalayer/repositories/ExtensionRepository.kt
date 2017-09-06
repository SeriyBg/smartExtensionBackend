package com.smartextension.backend.datalayer.repositories

import com.smartextension.backend.datalayer.entities.Extension
import org.springframework.data.repository.CrudRepository

interface ExtensionRepository : CrudRepository<Extension, Long>