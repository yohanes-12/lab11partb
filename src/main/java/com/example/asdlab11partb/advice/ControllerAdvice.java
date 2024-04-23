package com.example.asdlab11partb.advice;

import com.example.asdlab11partb.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    // NotFoundException advice
     @ExceptionHandler(NotFoundException.class)
     public ResponseEntity<?> handleNotFoundException(NotFoundException e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
     }



}
