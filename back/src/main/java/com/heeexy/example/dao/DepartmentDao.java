package com.heeexy.example.dao;

import com.heeexy.example.bean.Department;

import java.util.List;

public interface DepartmentDao {

    Department getDepartmentById(Integer id);

    List<Department> getDepartmentList();
}
