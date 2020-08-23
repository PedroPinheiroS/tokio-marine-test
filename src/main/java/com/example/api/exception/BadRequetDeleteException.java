package com.example.api.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class BadRequetDeleteException extends DataIntegrityViolationException {
    public BadRequetDeleteException(String msg) {
        super(msg);
    }
}
