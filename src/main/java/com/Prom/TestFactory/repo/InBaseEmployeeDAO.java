package com.Prom.TestFactory.repo;

import com.Prom.TestFactory.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InBaseEmployeeDAO {
    private final List<Employee> EMPLOYEES = new ArrayList<>();


    public List<Employee> findAllEmployee() {
        return EMPLOYEES;
    }


    public Employee saveEmployee(Employee employee) {
        EMPLOYEES.add(employee);
        return employee;
    }


    public Employee findByFIO(String FIO) {
        return EMPLOYEES.stream()
                .filter(element -> element.getFIO().equals(FIO))
                .findFirst()
                .orElse(null);
    }

    public Employee updateEmployee(Employee employee) {
        var employeeIndex = IntStream.range(0, EMPLOYEES.size())
                .filter(index -> EMPLOYEES.get(index).getFIO().equals(employee.getFIO()))
                .findFirst()
                .orElse(-1);
        if (employeeIndex > -1) {
            EMPLOYEES.set(employeeIndex, employee);
            return employee;
        }
        return null;
    }

    public void removeEmployee(String FIO) {
        var employee = findByFIO(FIO);
        if (employee != null) {
            EMPLOYEES.remove(employee);
        }
    }

}
