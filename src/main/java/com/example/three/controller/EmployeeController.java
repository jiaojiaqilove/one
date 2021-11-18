package com.example.three.controller;

import com.example.three.dao.Departmentdao;
import com.example.three.dao.Employeedao;
import com.example.three.pojo.Department;
import com.example.three.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    Employeedao employeedao;
    @Autowired
    Departmentdao departmentdao;

    @RequestMapping("/emps")
    //Model可以将dao的方法导入进去
    public String list(Model model) {
        /*将后端的内容跳转到前端画面*/
        Collection<Employee> employees = employeedao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toaddpage(Model model) {
        /*将后端的内容跳转到前端*/
        Collection<Department> departments = departmentdao.getDeparments();
        model.addAttribute("departments", departments);
        //查询部门的信息
        return "emp/add";
    }

    /*添加的操作*/
    @PostMapping("/emp")
    public String addemp(Employee employee) {

        /*调用底层员工的方法保存员工*/
        employeedao.save(employee);
        return "redirect:/emps";
    }

    //去员工的修改界面
    @GetMapping("/emp/{id}")
    public String toupdateemp(@PathVariable("id") Integer id, Model model) {
    //查出原来的数据
        Employee employee = employeedao.getEmployeebyid(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentdao.getDeparments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }
    /*修改的操作*/
    @PostMapping("/updateemp")
    public String updateemp(Employee employee) {
        /*调用底层员工的方法保存员工*/
        employeedao.save(employee);
        return "redirect:/emps";
    }
    /*删除的操作*/
    @GetMapping("/delete/{id}")
    public  String delemp(@PathVariable("id") int id){
        employeedao.delete(id);
        return "redirect:/emps";
    }

}





