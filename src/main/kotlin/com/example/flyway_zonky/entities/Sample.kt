package com.example.flyway_zonky.entities

import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table
data class Sample(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Type(type = "org.hibernate.type.PostgresUUIDType")
        @Column(name = "id", updatable = false, nullable = false)
        var id: UUID? = null,
        var data: String
)
