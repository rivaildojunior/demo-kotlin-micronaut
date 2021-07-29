package com.example.repository

import com.example.model.Usuario
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface UsuarioRepository: CrudRepository<Usuario, Long> {
}