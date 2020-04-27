package cn.edu.ustc.springboot.controller;

import cn.edu.ustc.springboot.bean.Employee;
import cn.edu.ustc.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmpById(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return employee;
    }

    @GetMapping("/del/{id}")
    public Integer delEmp(@PathVariable("id") Integer id) {
        return employeeService.delEmp(id);
    }
}
