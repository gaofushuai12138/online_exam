package com.heeexy.example.service;

import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Department;
import com.heeexy.example.bean.tableInfo.DepartmentTableInfo;

import java.util.List;

public interface DepartmentService {

    int addDepartment(DepartmentTableInfo department);

    int editDepartment(DepartmentTableInfo department);

    int deleteDepartment(Department department);

    PageInfo<DepartmentTableInfo> getDepartmentInfos();

    Department getDepartmentById(Integer id);

    List<Department> getDepartmentList();

    PageInfo<Department> getAllDepartmentInfos(DepartmentTableInfo departmentTableInfo);

}
