package com.br.cars.exception;

public class BadRequestException extends RuntimeException {

    private String message;

    public BadRequestException(String message) {
        super(message);
    }
}