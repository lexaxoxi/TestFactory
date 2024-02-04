package com.Prom.TestFactory.service;

import com.Prom.TestFactory.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> findAllEmployee();
    Employee saveEmployee(Employee employee);
    Employee findByFIO(String FIO);

    Employee updateEmployee(Employee employee);

    void removeEmployee(String FIO);
}
