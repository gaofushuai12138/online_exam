package com.heeexy.example.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Department;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.tableInfo.DepartmentTableInfo;
import com.heeexy.example.config.annotation.Log;
import com.heeexy.example.service.DepartmentService;
import io.swagger.annotations.Api;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
//    @Log(moudle = "部门管理",descrption = "查询部门列表")
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


    @Log(moudle = "部门管理",descrption = "添加部门")
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST)
    public Message addDepartment(@RequestBody DepartmentTableInfo departmentTableInfo){
        try {
            departmentService.addDepartment(departmentTableInfo);
            return new Message(Message.SUCCESS,"添加成功!",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"添加失败",null);
        }
    }


    @Log(moudle = "部门管理",descrption = "删除部门")
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST)
    public Message deleteDepartment(@RequestBody DepartmentTableInfo departmentTableInfo){
        try {
            departmentService.deleteDepartment(departmentTableInfo);
            return new Message(Message.SUCCESS,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.ERROR,"删除失败",null);
        }
    }



    @Log(moudle = "部门管理",descrption = "修改部门信息")
    @RequestMapping(value = "/updateDepartment",method = RequestMethod.POST)
    public Message updateDepartment(@RequestBody DepartmentTableInfo departmentTableInfo){
        try {
            System.out.println("部门:"+departmentTableInfo);
            departmentService.editDepartment(departmentTableInfo);
            return new Message(Message.SUCCESS,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.ERROR,"修改失败",null);
        }
    }
}
