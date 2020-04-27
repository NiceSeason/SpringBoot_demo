package cn.edu.ustc.springboot.mapper;

import cn.edu.ustc.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("DELETE FROM department WHERE id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);

    @Update("UPDATE department SET department_name=#{departmentName} WHERE id=#{id}")
    int updateDept(Department department);
}
