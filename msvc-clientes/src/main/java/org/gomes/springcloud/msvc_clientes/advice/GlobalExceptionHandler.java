package org.gomes.springcloud.msvc_clientes.advice;

import org.gomes.springcloud.msvc_clientes.dto.ErrDto;
import org.gomes.springcloud.msvc_clientes.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrDto> handleClientNotFound(ClientNotFoundException ex, WebRequest request) {

        ErrDto error = ErrDto.builder().message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value()).error("Cliente no encontrado")
                .path(request.getDescription(false)).timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
