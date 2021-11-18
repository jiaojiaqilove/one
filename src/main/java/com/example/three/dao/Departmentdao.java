package com.example.three.dao;

import com.example.three.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class Departmentdao {
    //模拟数据库的信息
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();//创建一个部门表

        departments.put(1001, new Department(1001, "教育部"));
        departments.put(1002, new Department(1002, "体育部"));
        departments.put(1003, new Department(1003, "考研部"));
        departments.put(1004, new Department(1004, "后勤部"));
        departments.put(1005, new Department(1005, "服务部"));
    }

    //获得部门信息
    public Collection<Department> getDeparments() {
        return departments.values();
    }
    //通过id得到部门
    public Department getDapartmentbyid(Integer id){
        return departments.get(id);
    }
}
