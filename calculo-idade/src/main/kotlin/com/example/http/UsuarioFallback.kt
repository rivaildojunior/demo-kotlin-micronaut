package com.example.http

import com.example.model.Usuario
import io.micronaut.retry.annotation.Fallback
import java.time.LocalDate

@Fallback
class UsuarioFallback: UsuarioHttp {

    override fun getUsuario(id: Long): Usuario {
        print("Fallback")
        return Usuario(1, "Joao", LocalDate.of(2020,1,19))
    }
}