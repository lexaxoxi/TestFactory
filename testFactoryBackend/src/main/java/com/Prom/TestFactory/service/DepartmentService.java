package com.Prom.TestFactory.service;

import com.Prom.TestFactory.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    public List<Department> findAllDepartment();
    Department saveDepartment(Department department);
    Optional<Department> findById(Long id);
    Department updateDepartment(Department updDepartment, Long id);
    void removeDepartment(Long id);
}
