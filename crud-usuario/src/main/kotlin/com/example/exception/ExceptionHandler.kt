package com.example.exception

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import javax.inject.Singleton
import io.micronaut.http.server.exceptions.ExceptionHandler;


@Produces
@Singleton
@Requires(classes = [RegistroNaoEncontradoException::class, ExceptionHandler::class])
class ExceptionHandler: ExceptionHandler<RegistroNaoEncontradoException, HttpResponse<*>> {

    override fun handle(request: HttpRequest<*>,
                        exception: RegistroNaoEncontradoException): HttpResponse<Erro> {
        var erro = Erro(
                status = HttpStatus.NOT_FOUND.code,
                error = HttpStatus.NOT_FOUND.name,
                message = exception.message,
                path = request.path)
        return HttpResponse.notFound<Erro>().body(erro);
    }

}