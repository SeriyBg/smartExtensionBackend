package com.smartextension.backend.datalayer.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
@Table(name = "users")
class User constructor(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id") var id: Long = 0,
        @Column(name = "username") var username: String = "",
        @JsonIgnore @Column(name = "password") var password: String = "",
        @JsonIgnore @Column(name = "role") var role: String = "") {

    companion object {
        val PASSWORD_ENCODER = BCryptPasswordEncoder()
    }

    fun setNewPassword(pass: String) {
        this.password = PASSWORD_ENCODER.encode(pass)
    }

}