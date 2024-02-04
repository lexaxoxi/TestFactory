package com.Prom.TestFactory.Impl;

import com.Prom.TestFactory.model.Employee;
import com.Prom.TestFactory.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InBaseEmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> findAllEmployee() {
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee findByFIO(String FIO) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void removeEmployee(String FIO) {

    }
}
