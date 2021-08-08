package com.example.exception

import java.time.LocalDateTime

data class Erro (val timestamp: String = LocalDateTime.now().toString(),
                 val status: Int,
                 val error: String,
                 val message: String?,
                 val path: String
)