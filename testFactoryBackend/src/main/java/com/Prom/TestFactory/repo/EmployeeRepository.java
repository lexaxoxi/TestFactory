package com.Prom.TestFactory.repo;

import com.Prom.TestFactory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void removeById(Long id);

    Optional<Employee> findById(Long id);

}