package com.smartextension.backend.datalayer.entities

import javax.persistence.*

@Entity
@Table(name = "socket")
class Socket constructor(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id") val id: Long = 0,
        var name: String = "",
        var extensionId: Long = 0.toLong(),
        @Transient var extension: Extension = Extension(),
        var ownerId: Long = 0)