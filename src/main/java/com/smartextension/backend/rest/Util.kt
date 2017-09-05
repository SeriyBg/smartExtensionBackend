package com.smartextension.backend.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

object Util {

    fun createResponseEntitiy(message : String, statusCode : HttpStatus) : ResponseEntity<String> {
        return ResponseEntity(message, statusCode)
    }

}