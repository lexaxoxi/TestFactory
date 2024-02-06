package com.Prom.TestFactory.controller;

import com.Prom.TestFactory.model.Employee;
import com.Prom.TestFactory.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @PostMapping("save_employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable Long id) {
        return employeeService.findById(id);
        //todo
        // .findById(id).get();

    }

    @PutMapping("update_employee/{id}")
    public Employee updateEmployee(@RequestBody Employee updEmployee, @PathVariable Long id) {
        return employeeService.findById(id)
                .map(currentEmployee -> {
                            currentEmployee.setFIO(updEmployee.getFIO());
                            currentEmployee.setProfession(updEmployee.getProfession());
                            currentEmployee.setDepartment(updEmployee.getDepartment());
                            currentEmployee.setNote(updEmployee.getNote());
                            return employeeService.saveEmployee(currentEmployee);
                        }
                )
                .orElseGet(() -> {
                            updEmployee.setId(id);
                            return employeeService.saveEmployee(updEmployee);
                        }
                );

    }

    @DeleteMapping("remove_employee/{id}")
    public void removeEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
    }
}
