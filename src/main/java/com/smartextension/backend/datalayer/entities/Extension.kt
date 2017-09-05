package com.smartextension.backend.datalayer.entities

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "extension")
class Extension : BaseEntity {

    var name = ""

    @Suppress("unused")
    constructor()

    constructor(name: String) : super() {
        this.name = name
    }

}