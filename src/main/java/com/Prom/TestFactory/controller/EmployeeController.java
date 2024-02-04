package com.Prom.TestFactory.controller;

import com.Prom.TestFactory.model.Employee;
import com.Prom.TestFactory.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
