package com.genesisresources.GenesisResourcesRegistry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.genesisresources.GenesisResourcesRegistry.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WrongPersonIdException.class)
    public ResponseEntity<ErrorResponse> handleWrongPersonId(WrongPersonIdException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), 400);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(),404);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}


