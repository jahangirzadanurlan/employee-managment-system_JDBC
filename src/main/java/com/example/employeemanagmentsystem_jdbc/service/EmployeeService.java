package com.example.employeemanagmentsystem_jdbc.service;

import com.example.employeemanagmentsystem_jdbc.dto.request.EmployeeDtoRequest;
import com.example.employeemanagmentsystem_jdbc.dto.response.EmployeeDtoResponse;
import com.example.employeemanagmentsystem_jdbc.dto.response.ResponseDto;
import com.example.employeemanagmentsystem_jdbc.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDtoResponse> findAll();
    EmployeeDtoResponse findById(Long id);
    ResponseDto insert(EmployeeDtoRequest employeeDtoRequest);
    ResponseDto update(EmployeeDtoRequest employeeDtoRequest);
    ResponseDto delete(Long id);
}
