package com.example.three.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表,虚拟的
@Data
//有参构造
@AllArgsConstructor
//五餐构造
@NoArgsConstructor
public class Department {
    private Integer id;
    private String name;

}
