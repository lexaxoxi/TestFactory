package com.Prom.TestFactory.repo;

import com.Prom.TestFactory.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void removeByFIO(String FIO);

    Employee findByFIO(String FIO);

}
