package com.example.controller

import com.example.model.Usuario
import com.example.service.UsuarioService
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/usuarios")
class UsuarioController {

    @Inject
    lateinit var usuarioService: UsuarioService

    @Post
    fun save(@Body usuario: Usuario): Usuario {
        return usuarioService.save(usuario)
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long): Usuario {
        return usuarioService.findById(id)
    }

    @Delete("/{id}")
    fun deleteById(@PathVariable id: Long): Boolean {
        return usuarioService.deleteById(id)
    }

    @Get
    fun findAll(): Iterable<Usuario> {
        return usuarioService.findAll()
    }

    @Put("/{id}")
    fun update(@Body usuario: Usuario, @PathVariable id: Long): Usuario {
        return usuarioService.update(usuario, id)
    }
}