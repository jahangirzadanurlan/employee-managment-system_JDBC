package com.example.employeemanagmentsystem_jdbc.controller;

import com.example.employeemanagmentsystem_jdbc.dto.request.EmployeeDtoRequest;
import com.example.employeemanagmentsystem_jdbc.dto.response.EmployeeDtoResponse;
import com.example.employeemanagmentsystem_jdbc.dto.response.ResponseDto;
import com.example.employeemanagmentsystem_jdbc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDtoResponse> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDtoResponse employeeById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @PostMapping
    public ResponseDto insert(@RequestBody EmployeeDtoRequest employeeDto){
        return employeeService.insert(employeeDto);
    }

    @PutMapping
    public ResponseDto delete(@RequestBody EmployeeDtoRequest employeeDto){
        return employeeService.update(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id){
        return employeeService.delete(id);
    }

}
