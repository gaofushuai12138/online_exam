package com.heeexy.example.controller;


import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.SysLog;
import com.heeexy.example.service.SysLogService;
import com.heeexy.example.bean.tableInfo.SysLogTableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /***
     * 分页查询系统日志
     * @param sysLog
     * @return
     */
    @RequestMapping(value = "/getAllSysLog",method = RequestMethod.POST)
    public Message getAllSysLog(@RequestBody SysLogTableInfo sysLog){
        try {
            System.out.println(sysLog.getSysLog());
            PageInfo<SysLog> pageInfo = sysLogService.getAllSysLog(sysLog);
            if(pageInfo != null){
                return new Message(Message.SUCCESS,"查询成功!",pageInfo);
            }else {
                return new Message(Message.FAILURE,"查询失败!",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.ERROR,"",null);
        }
    }
}
