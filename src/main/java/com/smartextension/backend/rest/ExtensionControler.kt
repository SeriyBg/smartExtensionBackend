package com.smartextension.backend.rest

import com.smartextension.backend.datalayer.entities.Extension
import com.smartextension.backend.datalayer.repositories.ExtensionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/extensions")
class ExtensionControler {

    @Autowired
    lateinit var extensionRepository : ExtensionRepository

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAllExtension() : Collection<Extension> {
        return ArrayList<Extension>(extensionRepository.findAll().toList())
    }

}