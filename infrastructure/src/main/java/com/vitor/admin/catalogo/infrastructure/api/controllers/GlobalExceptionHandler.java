package com.vitor.admin.catalogo.infrastructure.api.controllers;

import com.vitor.admin.catalogo.domain.exceptions.DomainException;
import com.vitor.admin.catalogo.domain.validation.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<?> handleDomainException(final DomainException ex){
        return ResponseEntity.unprocessableEntity().body(ApiError.from(ex));
    }

    record ApiError(String message, List<Error> errors){
        static ApiError from(final DomainException ex){
            return new ApiError(ex.getMessage(), ex.getErrors());
        }
    }

}
