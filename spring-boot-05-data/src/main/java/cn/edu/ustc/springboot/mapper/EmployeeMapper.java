package cn.edu.ustc.springboot.mapper;

import cn.edu.ustc.springboot.bean.Employee;

public interface EmployeeMapper {
    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
