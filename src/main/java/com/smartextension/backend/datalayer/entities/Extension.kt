package com.smartextension.backend.datalayer.entities

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "extension")
class Extension(var name: String = "") : BaseEntity()