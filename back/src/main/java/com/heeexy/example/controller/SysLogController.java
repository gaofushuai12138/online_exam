package com.heeexy.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.SysLog;
import com.heeexy.example.service.SysLogService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;
    /***
     * 插入日志
     * @param sysLog
     * @return
     */
//    @RequestMapping(value = "/insertSysLog",method = RequestMethod.POST)
//    public Message insertSysLog(@RequestBody SysLog sysLog){
//        try {
//            Integer res = sysLogService.addSysLog(sysLog);
//            if(res != null){
//                return new Message(Message.SUCCESS,"插入成功",null);
//            }else {
//                return new Message(Message.FAILURE,"插入失败",null);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return new Message(Message.ERROR,"插入失败",null);
//        }
//
//    }
}
