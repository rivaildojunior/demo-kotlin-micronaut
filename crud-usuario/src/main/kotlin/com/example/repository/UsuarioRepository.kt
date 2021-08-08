package com.example.repository

import com.example.model.Usuario
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable

@Repository
interface UsuarioRepository: JpaRepository<Usuario, Long> {

    fun findByNome(nome: String?, paginacao: Pageable): Page<Usuario>
}