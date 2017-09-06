package com.smartextension.backend.datalayer.entities

import javax.persistence.*

@Entity
@Table(name = "socket")
class Socket(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id") val id: Long = 0,
        var name: String = "",
        @ManyToOne(optional = false) var extension: Extension = Extension(),
        var ownerId: Long = 0)