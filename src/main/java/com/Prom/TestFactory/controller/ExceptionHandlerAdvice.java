package com.Prom.TestFactory.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ProblemDetail handleRemovalException(DataIntegrityViolationException e, HttpMethod httpMethod) {
        if (httpMethod.equals(HttpMethod.DELETE)) {
            String detail = "Данный удаляемый объект занят, удаление невозможно выполнить";
            return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), detail);
        }
        throw e;
    }


}
