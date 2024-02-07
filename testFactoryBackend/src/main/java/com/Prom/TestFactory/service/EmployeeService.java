package com.Prom.TestFactory.service;

import com.Prom.TestFactory.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    public List<Employee> findAllEmployee();

    Employee saveEmployee(Employee employee);

    Optional<Employee> findById(Long id);

    Employee updateEmployee(Employee updEmployee, Long id);

    void removeEmployee(Long id);
}
