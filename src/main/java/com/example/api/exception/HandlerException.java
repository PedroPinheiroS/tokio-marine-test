package com.example.api.exception;

import com.example.api.domain.RetornoErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<BadRequestException> handleGenericBadRequestException(BadRequestException e) {
        return new ResponseEntity(new RetornoErro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<NotFoundException> handleGenericNotFoundException(NotFoundException e) {
        return new ResponseEntity(new RetornoErro(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestViaCepException.class)
    public ResponseEntity<BadRequestViaCepException> handleGenericCepException(BadRequestViaCepException e) {
        return new ResponseEntity(new RetornoErro(e.getStatusText()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BadRequetDeleteException.class)
    public ResponseEntity<BadRequetDeleteException> handleGenericCepException(BadRequetDeleteException e) {
        return new ResponseEntity(new RetornoErro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
