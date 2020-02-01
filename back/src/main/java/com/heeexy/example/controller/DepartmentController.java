package com.heeexy.example.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Department;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.tableInfo.DepartmentTableInfo;
import com.heeexy.example.service.DepartmentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@Api("部门管理")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Message getDepartmentsList(){
        try {
            List departmentList = departmentService.getDepartmentList();
            if(departmentList != null){
                return new Message(Message.SUCCESS,"获取成功",departmentList);
            }else {
                return new Message(Message.FAILURE,"获取失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"获取失败",null);
        }
    }


    @RequestMapping(value = "/getAllDepartmentInfo",method = RequestMethod.POST)
    public Message getAllDepartmentInfo(@RequestBody DepartmentTableInfo departmentTableInfo){
        try {
            PageInfo<Department> pageInfo = departmentService.getAllDepartmentInfos(departmentTableInfo);
            if(pageInfo != null){
                return new Message(Message.SUCCESS,"查询成功",pageInfo);
            }else {
                return new Message(Message.FAILURE,"查询失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"查询失败",null);
        }
    }
}
