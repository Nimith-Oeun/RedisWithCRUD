package com.personal.crudwithredis.service.impl;

import com.personal.crudwithredis.dto.Employee;
import com.personal.crudwithredis.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final static String EMPLOYEE_KEY = "employee";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Employee> hashOperations;

    @PostConstruct
    public void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void saveEmployee(Employee employee) {

        hashOperations.put(EMPLOYEE_KEY, employee.getId(), employee);

    }

    @Override
    public void updateEmployee(Employee employee) {

        hashOperations.put(EMPLOYEE_KEY, employee.getId(), employee);

    }

    @Override
    public void deleteEmployee(Long id) {

        hashOperations.delete(EMPLOYEE_KEY, id);

    }

    @Override
    public Employee findbyid(Long id) {
        return hashOperations.get(EMPLOYEE_KEY, id);
    }

    @Override
    public List<Employee> getAllEmployees(String keys) {
        return hashOperations.values(keys);
    }

    @Override
    public List<Employee> findEmployeeById(List<Long> id) {
        return hashOperations.multiGet(EMPLOYEE_KEY, id);
    }

    @Override
    public Map<Long, Employee> getAll() {
        return hashOperations.entries(EMPLOYEE_KEY);
    }
}
