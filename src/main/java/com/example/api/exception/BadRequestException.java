package com.example.api.exception;

public class BadRequestException extends Throwable {
    public BadRequestException(String s) {
        super(s);
    }
}
