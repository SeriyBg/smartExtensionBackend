package com.smartextension.backend.datalayer.entities

import javax.persistence.*

@Entity
@Table(name = "extension")
class Extension(@Id
                @Column(name = "id")
                @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0,
                var name: String = "")