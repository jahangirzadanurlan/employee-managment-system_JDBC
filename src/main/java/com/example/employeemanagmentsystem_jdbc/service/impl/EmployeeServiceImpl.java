package com.example.employeemanagmentsystem_jdbc.service.impl;

import com.example.employeemanagmentsystem_jdbc.dto.request.EmployeeDtoRequest;
import com.example.employeemanagmentsystem_jdbc.dto.response.EmployeeDtoResponse;
import com.example.employeemanagmentsystem_jdbc.dto.response.ResponseDto;
import com.example.employeemanagmentsystem_jdbc.exception.EmployeeNotFoundException;
import com.example.employeemanagmentsystem_jdbc.model.Employee;
import com.example.employeemanagmentsystem_jdbc.repository.EmployeeRepository;
import com.example.employeemanagmentsystem_jdbc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<EmployeeDtoResponse> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee->modelMapper.map(employee,EmployeeDtoResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDtoResponse findById(Long id) {
        return modelMapper.map(employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new),EmployeeDtoResponse.class);
    }

    @Override
    public ResponseDto insert(EmployeeDtoRequest employeeDtoRequest) {
        return employeeRepository.insert(modelMapper.map(employeeDtoRequest, Employee.class))>0
                ?new ResponseDto("Employee created successfully!"):
                new ResponseDto("Employee created failed!!!");
    }

    @Override
    public ResponseDto update(EmployeeDtoRequest employeeDtoRequest) {
        return employeeRepository.update(modelMapper.map(employeeDtoRequest,Employee.class))>0
                ?new ResponseDto("Employee updated successfully!"):
                new ResponseDto("Employee updated failed!!!");
    }

    @Override
    public ResponseDto delete(Long id) {
        return employeeRepository.delete(id)>0
                ?new ResponseDto("Employee deleted successfully!"):
                new ResponseDto("Employee deleted failed!!!");
    }
}
