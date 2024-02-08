package com.Prom.TestFactory.repo;

import com.Prom.TestFactory.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    void removeById(Long id);

    Optional<Department> findById(Long id);

}
