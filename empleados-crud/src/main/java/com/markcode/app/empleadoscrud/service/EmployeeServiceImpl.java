package com.markcode.app.empleadoscrud.service;

import com.markcode.app.empleadoscrud.exception.ResourceNotFoundException;
import com.markcode.app.empleadoscrud.models.Employee;
import com.markcode.app.empleadoscrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id: " + id));
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
       System.out.println("EmployeeServiceImpl::createEmployee.....");
       System.out.println(employee.getId() +" - "+
        employee.getFirtsName() +" - "+
        employee.getLastName() +" - "+
        employee.getEmailId()
       );
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employee.setFirtsName(employeeDetails.getFirtsName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        return employeeRepository.save(employee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not exist with id: " + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
