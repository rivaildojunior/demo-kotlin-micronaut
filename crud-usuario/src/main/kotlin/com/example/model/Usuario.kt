package com.example.model

import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.persistence.*

@Introspected
@Entity(name="usuario")
data class Usuario(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        val id: Long? = null,
        @Column
        var nome: String? = null,
        @Column
        var dataNascimento: LocalDate? = null
)