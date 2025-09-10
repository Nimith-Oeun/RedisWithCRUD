package com.personal.crudwithredis.controller;

import com.personal.crudwithredis.dto.Employee;
import com.personal.crudwithredis.dto.EmployeeReq;
import com.personal.crudwithredis.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<?>saveEmployee(@RequestBody Employee employee){
        try{
            employeeService.saveEmployee(employee);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            log.error("fail to save employee", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?>updateEmployee(@RequestBody Employee employee){
        try{
            Employee emp = employeeService.findbyid(employee.getId());
            if (emp != null){
                employeeService.updateEmployee(employee);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            log.error("fail to save employee", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?>deleteEmployee(@RequestParam("id") Long id){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.error("fail to save employee", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/emp/id")
    public ResponseEntity<?>getEmployeeById(@RequestParam("id") Long id){
        try{
            return new ResponseEntity<>(employeeService.findbyid(id), HttpStatus.OK);
        }catch (Exception e){
            log.error("fail to save employee", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/emp/list")
    public ResponseEntity<?>listAllEmployee(){
        try{
            return new ResponseEntity<>(employeeService.getAllEmployees("employee"), HttpStatus.OK);
        }catch (Exception e){
            log.error("find all failer", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/emp/find/id")
    public ResponseEntity<?>listAllEmployeeByid(@RequestBody EmployeeReq employee){
        try{
            List<Employee> list = employeeService.findEmployeeById(employee.getId());
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (Exception e){
            log.error("find all failer", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/emp/all")
    public ResponseEntity<?>getAll(){
        try{
            Map<Long, Employee> map = employeeService.getAll();
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception e){
            log.error("find all failer", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
