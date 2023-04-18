package com.example.employeemanagmentsystem_jdbc.exception;

import com.example.employeemanagmentsystem_jdbc.enums.Exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(){
        super(Exceptions.EMPLOYEE_NOT_FOUND_EXCEPTION.getMessage());
    }
}
