package com.smartextension.backend.datalayer.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "socket")
class Socket constructor(var name: String = "", @Column(
        name = "extensionId") var extentionId: Long = 0.toLong()) : BaseEntity() {

}