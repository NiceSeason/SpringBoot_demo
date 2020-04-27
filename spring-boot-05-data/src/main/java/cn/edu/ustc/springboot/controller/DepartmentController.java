package cn.edu.ustc.springboot.controller;

import cn.edu.ustc.springboot.bean.Department;
import cn.edu.ustc.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentMapper deptMapper;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id) {
        return deptMapper.getDeptById(id);
    }

    @GetMapping("/delete/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id) {
        return deptMapper.deleteDeptById(id);
    }

    @GetMapping("/insert")
    public Department insert(Department department) {
        deptMapper.insertDept(department);
        return department;
    }

    @GetMapping("/update")
    public Department update(Department department) {
         deptMapper.updateDept(department);
        return department;
    }
}
