package com.Prom.TestFactory.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String FIO;
    private String Profession;
    private String Department;
    private String Note;
}
