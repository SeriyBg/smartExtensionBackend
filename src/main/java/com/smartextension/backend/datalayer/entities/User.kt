package com.smartextension.backend.datalayer.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.Entity

@Entity
class User() : BaseEntity() {

    companion object {
        val PASSWORD_ENCODER = BCryptPasswordEncoder()
    }

    var firstName = ""

    var lastName = ""

    var username = ""

    @JsonIgnore
    var password = ""
    set(value) {
        field = PASSWORD_ENCODER.encode(value)
    }

    @JsonIgnore
    lateinit var roles : Array<String>

    constructor(firstName : String, lastName : String, username : String, password : String, roles : Array<String>) : this() {
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.password = password
        this.roles = roles
    }
}