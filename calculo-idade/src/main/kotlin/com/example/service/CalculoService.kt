package com.example.service

import com.example.http.UsuarioHttp
import com.example.model.Usuario
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalculoService {

    @Inject
    lateinit var usuarioHttp: UsuarioHttp

    fun calcularIdade(id: Long): Long {
        var dataAtual: LocalDate = LocalDate.now();

        var usuario : Usuario = usuarioHttp.getUsuario(id);
        val dataNascimento = usuario.dataNascimento;

        return ChronoUnit.YEARS.between(dataNascimento, dataAtual);
    }
}