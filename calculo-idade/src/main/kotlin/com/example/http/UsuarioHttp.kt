package com.example.http

import com.example.model.Usuario
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8080")
interface UsuarioHttp {

    @Get("/usuarios/{id}")
    fun getUsuario(@PathVariable id: Long) : Usuario;
}