package com.Prom.TestFactory.Impl;

import com.Prom.TestFactory.model.Employee;
import com.Prom.TestFactory.repo.EmployeeRepository;
import com.Prom.TestFactory.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;


    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByFIO(String FIO) {
        return employeeRepository.findByFIO(FIO);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void removeEmployee(String FIO) {
        employeeRepository.removeByFIO(FIO);

    }
}
