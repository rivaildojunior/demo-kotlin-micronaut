package com.example.controller

import com.example.service.CalculoService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces
import javax.inject.Inject

@Controller("/calculo")
class CalculoController {

    @Inject
    lateinit var calculoService: CalculoService

    @Get("/teste")
    @Produces(MediaType.TEXT_PLAIN)
    fun teste(): String {
        return "OK"
    }

    @Get("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    fun calcular(@PathVariable id: Long): Long {
        return calculoService.calcularIdade(id);
    }
}