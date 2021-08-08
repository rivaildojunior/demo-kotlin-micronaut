package com.example.service

import com.example.exception.RegistroNaoEncontradoException
import com.example.model.Usuario
import com.example.repository.UsuarioRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import javax.inject.Singleton

@Singleton
open class UsuarioService(val usuarioRepository: UsuarioRepository) {

    open fun save(usuario: Usuario): Usuario {
        usuarioRepository.save(usuario)
        return usuario
    }

    open fun findById(id: Long): Usuario {
        return usuarioRepository.findById(id)
                .orElseThrow{RegistroNaoEncontradoException("Registro não encontrado")}
    }

    open fun deleteById(id: Long): Unit {
        var usuarioDB: Usuario = findById(id);
        return usuarioRepository.delete(usuarioDB)
    }

    open fun findAll(nome: String?, paginacao: Pageable): Page<Usuario> {
        var lista = if (nome == null){
            usuarioRepository.findAll(paginacao)
        } else {
            usuarioRepository.findByNome(nome, paginacao)
        }
        return lista
    }

    open fun update(usuario: Usuario, id: Long): Usuario {
        var usuarioDB: Usuario = findById(id);
        usuarioDB.nome = usuario.nome;
        return usuarioRepository.update(usuarioDB)
    }
}