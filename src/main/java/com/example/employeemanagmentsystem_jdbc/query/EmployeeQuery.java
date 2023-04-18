package com.example.employeemanagmentsystem_jdbc.query;

public class EmployeeQuery {
    public static final String INSERT_EMPLOYEE="INSERT INTO employee(name,country) VALUES(name= :name,country= :country)";
    public static final String EMPLOYEE_LIST="SELECT * FROM employee";
    public static final String EMPLOYEE_FIND_BY_ID="SELECT * FROM employee WHERE id= :id";
    public static final String UPDATE_EMPLOYEE_BY_ID="UPDATE employee SET name= :name,country= :country WHERE id=?";
    public static final String DELETE_BY_ID="DELETE FROM employee WHERE id= :id";
}
