package com.example.controller

import com.example.model.Usuario
import com.example.service.UsuarioService
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse

import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import java.net.URI

@Controller("/usuarios")
class UsuarioController(val usuarioService: UsuarioService) {

    @Post
    fun save(@Body usuario: Usuario): HttpResponse<Usuario> {
        val usuarioSalvo: Usuario = usuarioService.save(usuario)
        val uri: URI = UriBuilder.of("/usuarios/${usuarioSalvo.id}").build()
        return HttpResponse.created(usuarioSalvo, uri)
    }

    @Get("/{id}")
    fun findById(@PathVariable id: Long): Usuario {
        return usuarioService.findById(id)
    }

    @Delete("/{id}")
    fun deleteById(@PathVariable id: Long): HttpResponse<Unit> {
        usuarioService.deleteById(id)
        return HttpResponse.noContent();
    }

    @Get
    fun findAll(@QueryValue nome: String?, paginacao: Pageable): Page<Usuario> {
        return usuarioService.findAll(nome, paginacao)
    }

    @Put("/{id}")
    fun update(@Body usuario: Usuario, @PathVariable id: Long): HttpResponse<Usuario> {
        return HttpResponse.ok(usuarioService.update(usuario, id))
    }
}