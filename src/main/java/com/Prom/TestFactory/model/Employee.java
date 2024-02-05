package com.Prom.TestFactory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String FIO;
    private String profession;
    private String department;
    private String note;
}
