package com.example.service

import com.example.model.Usuario
import com.example.repository.UsuarioRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsuarioService {

    @Inject
    open lateinit var usuarioRepository: UsuarioRepository

    open fun save(usuario: Usuario): Usuario {
        usuarioRepository.save(usuario)
        return usuario
    }

    open fun findById(id: Long): Usuario {
        return usuarioRepository.findById(id).orElse(null)
    }

    open fun deleteById(id: Long): Boolean {
        try {
            usuarioRepository.deleteById(id)
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    open fun findAll(): Iterable<Usuario> {
        return usuarioRepository.findAll()
    }

    open fun update(usuario: Usuario, id: Long): Usuario {
        var usuarioDB: Usuario = findById(id);
        usuarioDB.nome = usuario.nome;
        return usuarioRepository.update(usuarioDB)
    }
}