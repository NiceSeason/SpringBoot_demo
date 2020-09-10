package cn.edu.ustc.springboot.service;

import cn.edu.ustc.springboot.bean.Employee;
import cn.edu.ustc.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(value={"emp"}
            ,key = "#id+#root.methodName+#root.caches[0].name"
//            ,keyGenerator = "myKeyGenerator"
//            ,condition = "#a0>1"
//            unless = "#p0==2"
    )
    public Employee getEmpById(Integer id) {
        System.out.println("查询员工："+id);
        return employeeMapper.getEmpById(id);
    }

    @CachePut(value = {"emp"},key = "#employee.id" )
    public Employee updateEmp(Employee employee) {
        System.out.println("更新员工"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = {"emp"},allEntries = true,beforeInvocation = true)
    public Integer delEmp(Integer id){
        int i=1/0;
        System.out.println("删除员工："+id);
        employeeMapper.delEmp(id);
        return id;
    }
}

