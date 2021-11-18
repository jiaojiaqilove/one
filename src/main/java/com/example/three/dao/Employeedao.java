package com.example.three.dao;

import com.example.three.pojo.Department;
import com.example.three.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
//员工dao
public class Employeedao {
    //模拟数据库的信息
    private static Map<Integer, Employee> employees = null;

    //员工所属的部门
    @Autowired
    private Departmentdao departmentdao;

    static {
        employees = new HashMap<Integer, Employee>();//创建一个部门表
        employees.put(1001, new Employee(1001, "AA", "321312@qq.com", 1, new Department(1001, "后勤部")));
        employees.put(1002, new Employee(1002, "BB", "321313@qq.com", 1, new Department(1002, "后勤部")));
        employees.put(1003, new Employee(1003, "CC", "321314@qq.com", 0, new Department(1003, "考研部")));
        employees.put(1004, new Employee(1004, "DD", "321315@qq.com", 1, new Department(1004, "后勤部")));
    }

    //主键自增
    private static Integer initid = 1005;

    //增加员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initid++);
        }
        //部门关联外键
        employee.setDepartment(departmentdao.getDapartmentbyid(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    //获得员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }
    //通过id得到员工
    public Employee getEmployeebyid(Integer id){
        return employees.get(id);
    }
    //删除员工通过id
    public void delete(Integer id){
        employees.remove(id);
    }

}
