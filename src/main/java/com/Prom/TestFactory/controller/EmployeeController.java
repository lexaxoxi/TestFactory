package com.Prom.TestFactory.controller;

import com.Prom.TestFactory.model.Employee;
import com.Prom.TestFactory.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

        @GetMapping
        public List<Employee> findAllEmployee () {
//TODO
            return employeeService.findAllEmployee();
        }
        @PostMapping("save_employee")
        public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
        }
        @GetMapping("/{FIO}")
        public Employee findByFIO(@PathVariable String FIO) {
            return employeeService.findByFIO(FIO);
        }

        @PutMapping("update_employee")
        public Employee updateEmployee(@RequestBody Employee employee) {
            return employeeService.updateEmployee(employee);
        }

        @DeleteMapping("delete_employee/{FIO}")
    public void removeEmployee(@PathVariable String FIO) {
            employeeService.removeEmployee(FIO);
        }
}
