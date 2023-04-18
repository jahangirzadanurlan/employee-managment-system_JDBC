package com.example.employeemanagmentsystem_jdbc.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum Exceptions {
    EMPLOYEE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"Employee not found");

    private HttpStatus httpStatus;
    private String message;

    Exceptions(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
