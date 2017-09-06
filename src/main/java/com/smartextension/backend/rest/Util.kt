package com.smartextension.backend.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

fun fieldCannotBeEmptyResponse(fieldName: String)
        = ResponseEntity<String>("$fieldName cannot be empty", HttpStatus.BAD_REQUEST)