package com.example.employeemanagmentsystem_jdbc.repository.impl;

import com.example.employeemanagmentsystem_jdbc.model.Employee;
import com.example.employeemanagmentsystem_jdbc.query.EmployeeQuery;
import com.example.employeemanagmentsystem_jdbc.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final NamedParameterJdbcTemplate template;
    @Override
    public List<Employee> findAll() {
        return template.query(EmployeeQuery.EMPLOYEE_LIST,
                ((rs, rowNum) -> Employee.builder()
                        .name(rs.getString("name"))
                        .country(rs.getString("country"))
                        .id(rs.getLong("id"))
                        .build()));
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return template.query(EmployeeQuery.EMPLOYEE_FIND_BY_ID,
                paramMap,
                (rs, rowNum) -> Employee.builder()
                        .name(rs.getString("name"))
                        .country(rs.getString("country"))
                        .id(rs.getLong("id"))
                        .build())
                .stream()
                .findFirst();
    }

    @Override
    public int insert(Employee employee) {
        Map<String,Object>paramMap=new HashMap<>();
        paramMap.put("name",employee.getName());
        paramMap.put("country",employee.getCountry());
        return template.update(EmployeeQuery.INSERT_EMPLOYEE,
                paramMap);
    }

    @Override
    public int update(Employee employee) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", employee.getName());
        paramMap.put("country", employee.getCountry());
        paramMap.put("id", employee.getId());
        return template.update(EmployeeQuery.UPDATE_EMPLOYEE_BY_ID,paramMap);
    }

    @Override
    public int delete(Long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return template.update(EmployeeQuery.DELETE_BY_ID,paramMap);
    }
}
