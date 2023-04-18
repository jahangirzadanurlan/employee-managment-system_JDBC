package com.example.employeemanagmentsystem_jdbc.handler;

import com.example.employeemanagmentsystem_jdbc.dto.response.ExceptionResponse;
import com.example.employeemanagmentsystem_jdbc.enums.Exceptions;
import com.example.employeemanagmentsystem_jdbc.exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ExceptionResponse handle(){
        return ExceptionResponse.builder()
                .localDateTime(LocalDateTime.now())
                .message(Exceptions.EMPLOYEE_NOT_FOUND_EXCEPTION.getMessage())
                .build();
    }
}
