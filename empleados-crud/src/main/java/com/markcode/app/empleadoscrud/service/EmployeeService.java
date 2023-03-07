package com.markcode.app.empleadoscrud.service;

import com.markcode.app.empleadoscrud.models.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    Map<String, Boolean> deleteEmployee(Long id);
}
