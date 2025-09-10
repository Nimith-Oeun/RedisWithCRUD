package com.personal.crudwithredis.service;

import com.personal.crudwithredis.dto.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    Employee findbyid(Long id);
    List<Employee> getAllEmployees(String keys);
    List<Employee> findEmployeeById(List<Long> id);
    Map<Long, Employee> getAll();
}
