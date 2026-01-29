package com.example;

public class CoustomException extends Exception {
    private String message;

    public CoustomException(String mess) {
        this.message = mess;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
