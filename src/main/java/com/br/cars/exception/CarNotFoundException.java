package com.br.cars.exception;

public class CarNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public CarNotFoundException(String s) {
        super((String) null);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

