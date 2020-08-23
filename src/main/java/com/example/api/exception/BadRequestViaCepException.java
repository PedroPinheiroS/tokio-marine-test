package com.example.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class BadRequestViaCepException extends HttpClientErrorException {
    public BadRequestViaCepException(String s) {
        super(HttpStatus.BAD_REQUEST, s);
    }


}
