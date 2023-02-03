package com.techni.demoexception.controllers;

import com.techni.demoexception.exception.WrongBirthDateException;
import com.techni.demoexception.models.dtos.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(WrongBirthDateException.class)
    public ResponseEntity<ErrorDTO> handleBirthDateException(
            WrongBirthDateException e, HttpServletRequest request
    ) {
        ErrorDTO errorDTO = new ErrorDTO(
                request.getMethod(),
                request.getRequestURL().toString(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(
            MethodArgumentNotValidException e, HttpServletRequest request
    ) {
        ErrorDTO errorDTO = new ErrorDTO(
                request.getMethod(),
                request.getRequestURL().toString(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }
}
