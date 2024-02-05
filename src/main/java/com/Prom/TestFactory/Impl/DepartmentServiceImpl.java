package com.Prom.TestFactory.Impl;

import com.Prom.TestFactory.model.Department;
import com.Prom.TestFactory.repo.DepartmentRepository;
import com.Prom.TestFactory.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;


    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment (Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department updateDepartment(Department updDepartment, Long id) {
        return departmentRepository.save(updDepartment);
    }

    @Override
    @Transactional
    public void removeDepartment(Long id) {
        departmentRepository.removeById(id);

    }
}
