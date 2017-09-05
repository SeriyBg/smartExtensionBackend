package com.smartextension.backend.datalayer.entities

import javax.persistence.Entity

@Entity
class Socket : BaseEntity {

    var name: String

    @Suppress("unused")
    constructor() {
        this.name = ""
    }

    constructor(name: String) : super() {
        this.name = name
    }
}