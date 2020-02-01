package com.heeexy.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Department;

import com.heeexy.example.bean.tableInfo.DepartmentTableInfo;
import com.heeexy.example.dao.DepartmentDao;
import com.heeexy.example.service.DepartmentService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public int addDepartment(DepartmentTableInfo department) {
        return departmentDao.insertDepartment(department);
    }

    @Override
    public int editDepartment(DepartmentTableInfo department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public int deleteDepartment(DepartmentTableInfo department) {
        return departmentDao.deleteDepartment(department);
    }

    @Override
    public PageInfo<DepartmentTableInfo> getDepartmentInfos() {
        return null;
    }

    @Override
    public Department getDepartmentById(Integer id) {
       return departmentDao.getDepartmentById(id);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.getDepartmentList();
    }

    @Override
    public PageInfo<Department> getAllDepartmentInfos(DepartmentTableInfo departmentTableInfo) {
        PageHelper.startPage(departmentTableInfo.getPageNum(),departmentTableInfo.getPageSize());
        List<Department> departments = departmentDao.getDepartmentList();
        PageInfo<Department> pageInfo = new PageInfo<>(departments);
        return pageInfo;
    }
}
