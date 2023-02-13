package com.br.cars.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String message) {
        super(message);
    }
}
