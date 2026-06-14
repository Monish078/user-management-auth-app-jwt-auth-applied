package com.project_intermediate.UserManagement_System_App.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice  // yaha pe sare exception pakde jate hai , catch hote hai
public class GlobalExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)  // ye exception ko handle karta hai aur message bhejta hau
    public ResponseEntity<String> handle(UserNotFoundException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }


    // Validation -> register ke time wrong field bhejna , formate sahi na hone pe mesage bhejta hi
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()));  // wrong input dene pe message print hoga

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<String> handleDuplicateEmailException(EmailAlreadyExistException ex) {

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }




}
