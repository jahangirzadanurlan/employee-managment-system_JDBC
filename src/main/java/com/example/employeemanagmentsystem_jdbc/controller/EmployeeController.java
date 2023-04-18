package com.example.employeemanagmentsystem_jdbc.controller;

import com.example.employeemanagmentsystem_jdbc.dto.request.EmployeeDtoRequest;
import com.example.employeemanagmentsystem_jdbc.dto.response.EmployeeDtoResponse;
import com.example.employeemanagmentsystem_jdbc.dto.response.ResponseDto;
import com.example.employeemanagmentsystem_jdbc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDtoResponse> findAll(){
        log.info("GET - /employees -> request none");
        var response = employeeService.findAll();
        log.info("GET - /employees -> response -> {}",response);
        return response;
    }

    @GetMapping("/{id}")
    public EmployeeDtoResponse employeeById(@PathVariable Long id){
        log.info("GET - /employees/{} -> request",id);
        var response = employeeService.findById(id);
        log.info("GET - /employees/{} -> response -> {}",id,response);
        return response;
    }

    @PostMapping
    public ResponseDto insert(@RequestBody EmployeeDtoRequest employeeDto){
        log.info("GET - /employees -> request ");
        var response = employeeService.insert(employeeDto);
        log.info("GET - /employees -> response -> {}",response);
        return response;
    }

    @PutMapping
    public ResponseDto delete(@RequestBody EmployeeDtoRequest employeeDto){
        log.info("GET - /employees -> request none");
         var response= employeeService.update(employeeDto);
        log.info("GET - /employees -> response -> {}",response);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id){
        log.info("GET - /employees -> request none");
        var response =employeeService.delete(id);
        log.info("GET - /employees -> response -> {}",response);
        return response;
    }

}
