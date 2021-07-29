package com.example.model

import java.time.LocalDate
import javax.persistence.*

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