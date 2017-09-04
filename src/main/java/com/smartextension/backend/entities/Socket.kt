package com.smartextension.backend.entities

import javax.persistence.Entity

@Entity
class Socket : BaseEntity {
    private var name: String

    constructor() {
        this.name = ""
    }

    constructor(name: String) : super() {
        this.name = name
    }
}