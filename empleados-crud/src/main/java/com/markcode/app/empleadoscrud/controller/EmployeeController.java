package com.markcode.app.empleadoscrud.controller;

import com.markcode.app.empleadoscrud.models.Employee;
import com.markcode.app.empleadoscrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> getEmployeeById(@RequestBody Employee employee) {
        return ResponseEntity.ok( employeeService.createEmployee(employee) );
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable  Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok( employeeService.updateEmployee(id, employee) );
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> updateEmployee(@PathVariable  Long id) {
        return ResponseEntity.ok( employeeService.deleteEmployee(id) );
    }



}
