package io.git.yhugorocha.learning.controller;

import io.git.yhugorocha.learning.exception.FieldError;
import io.git.yhugorocha.learning.exception.StandartError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public StandartError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getFieldErrors().stream()
                .map(field -> new FieldError(field.getField(), field.getDefaultMessage()))
                .toList();

        return new StandartError(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de validação",
                System.currentTimeMillis(),
                fieldErrors);
    }
}
