package com.Prom.TestFactory.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String FIO;
    @ManyToOne
    private Profession profession;
    @ManyToOne
    private Department department;
    private String note;
}
