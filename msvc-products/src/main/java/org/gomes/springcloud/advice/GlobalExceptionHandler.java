package org.gomes.springcloud.advice;

import org.gomes.springcloud.dto.ErrDto;
import org.gomes.springcloud.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrDto> handleClientNotFound(ProductNotFoundException ex, WebRequest request) {
        ErrDto error = ErrDto.builder().message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value()).error("Cliente no encontrado")
                .path(request.getDescription(false)).timestamp(LocalDateTime.now()).build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
