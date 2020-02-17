package com.heeexy.example.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.Subject;
import com.heeexy.example.bean.tableInfo.SubjectTableInfo;
import com.heeexy.example.bean.tableInfo.SysLogTableInfo;
import com.heeexy.example.service.SubjectService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.cs.ext.MS874;

import java.security.PublicKey;
import java.util.HashMap;

@RestController
@RequestMapping("/subject")
public class SubjectController {


    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/insertSubject",method = RequestMethod.POST)
    public Message addSubject(@RequestBody SubjectTableInfo subjectTableInfo){
        try {
            JSONObject jsonObject = JSONObject.parseObject(subjectTableInfo.getSubject().toJson());
            HashMap map = CommonUtil.AllRequired(jsonObject,"subjectName");
            if(map != null){
                return new Message(Message.FAILURE,"添加失败",map.get("msg"));
            }
            subjectService.insertSubject(subjectTableInfo);
            return new Message(Message.SUCCESS,"添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"添加失败!",null);
        }
    }


    @RequestMapping(value = "/deleteSubject",method = RequestMethod.POST)
    public Message deleteSubject(@RequestBody SubjectTableInfo subjectTableInfo){
        try {
            subjectService.deleteSubject(subjectTableInfo);
            return new Message(Message.SUCCESS,"删除成功!",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"删除失败!",null);
        }
    }



    @RequestMapping(value = "/updatesubject",method = RequestMethod.POST)
    public Message updateSubject(@RequestBody SubjectTableInfo subjectTableInfo){
        try {
            JSONObject jsonObject = JSONObject.parseObject(subjectTableInfo.getSubject().toJson());
            System.out.println(jsonObject);
            HashMap map = CommonUtil.AllRequired(jsonObject,"subjectName");
            System.out.println(map);
            if(map != null){
                return new Message(Message.FAILURE,"修改失败",map.get("msg"));
            }
            subjectService.updateSubject(subjectTableInfo);
            return new Message(Message.SUCCESS,"修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.ERROR,"修改失败",null);
        }
    }


    @RequestMapping(value = "/listsubjects",method = RequestMethod.POST)
    public Message getAllSubjects(@RequestBody SubjectTableInfo subjectTableInfo){
        try {
            PageInfo<Subject> pageInfo = subjectService.getAllSubject(subjectTableInfo);
            return new Message(Message.SUCCESS,"查询成功!",pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.ERROR,"查询失败!",null);
        }
    }



}
