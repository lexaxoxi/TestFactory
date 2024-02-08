package com.Prom.TestFactory.controller;

import com.Prom.TestFactory.model.Department;
import com.Prom.TestFactory.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.findAllDepartment();
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> findById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@RequestBody Department updDepartment, @PathVariable Long id) {
        return departmentService.findById(id).map(currentDepartment -> {
            currentDepartment.setTitle(updDepartment.getTitle());
            currentDepartment.setNote(updDepartment.getNote());
            currentDepartment.setParent(updDepartment.getParent());

            return departmentService.saveDepartment(currentDepartment);
        }).orElseGet(() -> {
            updDepartment.setId(id);
            return departmentService.saveDepartment(updDepartment);
        });

    }
    @DeleteMapping("/{id}")
    public void removeDepartment(@PathVariable Long id) {
        departmentService.removeDepartment(id);
    }
}
