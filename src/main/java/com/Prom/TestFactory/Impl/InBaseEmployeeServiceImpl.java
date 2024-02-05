package com.Prom.TestFactory.Impl;

import com.Prom.TestFactory.model.Employee;
import com.Prom.TestFactory.repo.InBaseEmployeeDAO;
import com.Prom.TestFactory.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InBaseEmployeeServiceImpl implements EmployeeService {
    private final InBaseEmployeeDAO repository;


    @Override
    public List<Employee> findAllEmployee() {
        return repository.findAllEmployee();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.saveEmployee(employee);
    }

    @Override
    public Employee findByFIO(String FIO) {
        return repository.findByFIO(FIO);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repository.updateEmployee(employee);
    }

    @Override
    public void removeEmployee(String FIO) {
        repository.removeEmployee(FIO);

    }
}
