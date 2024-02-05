package com.Prom.TestFactory.Impl;

import com.Prom.TestFactory.model.Employee;
import com.Prom.TestFactory.repo.EmployeeRepository;
import com.Prom.TestFactory.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee updEmployee, Long id) {
        return employeeRepository.save(updEmployee);
    }

    @Override
    @Transactional
    public void removeEmployee(Long id) {
        employeeRepository.removeById(id);

    }
}
