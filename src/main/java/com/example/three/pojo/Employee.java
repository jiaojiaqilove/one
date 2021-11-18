package com.example.three.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gander;
    private Department department;
    private Date date;

    public Employee(Integer id, String lastName, String email, Integer gander, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gander = gander;
        this.department = department;
        this.date =new Date();
    }
}
