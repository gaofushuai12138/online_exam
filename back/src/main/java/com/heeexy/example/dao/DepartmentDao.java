package com.heeexy.example.dao;

import com.heeexy.example.bean.Department;
import com.heeexy.example.bean.tableInfo.DepartmentTableInfo;

import java.util.List;

public interface DepartmentDao {

    Department getDepartmentById(Integer id);

    List<Department> getDepartmentList();

    int insertDepartment(DepartmentTableInfo department);

    int deleteDepartment(DepartmentTableInfo department);

    int updateDepartment(DepartmentTableInfo departmentTableInfo);
}
