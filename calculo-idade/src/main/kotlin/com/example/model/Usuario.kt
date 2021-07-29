package com.example.model

import java.time.LocalDate

data class Usuario(
        val id: Long? = null,
        var nome: String? = null,
        var dataNascimento: LocalDate? = null
)