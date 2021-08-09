package com.example.http

import com.example.model.Usuario
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker

@Client(id = "usuario")
@CircuitBreaker(delay = "1s", attempts = "1", multiplier = "1", reset = "30s")
interface UsuarioHttp {

    @Get("/usuarios/{id}")
    fun getUsuario(@PathVariable id: Long) : Usuario;
}