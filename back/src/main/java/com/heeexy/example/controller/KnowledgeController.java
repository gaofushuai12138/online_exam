package com.heeexy.example.controller;


import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.KnowledgePoint;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.tableInfo.KnowledgeTableInfo;
import com.heeexy.example.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private KnowledgeService knowledgeService;


    @RequestMapping(value = "/insertKnowledge",method = RequestMethod.POST)
    public Message insertKnowledgeList(@RequestBody KnowledgeTableInfo knowledgeTableInfo){
        try {
            System.out.println(knowledgeTableInfo.getKnowledgePoint());
            knowledgeService.insertKnowledge(knowledgeTableInfo);
            return new Message(Message.SUCCESS,"添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"添加失败",null);
        }
    }


    @RequestMapping(value = "/getKnowledgeList",method = RequestMethod.POST)
    public Message getKnowledgeList(@RequestBody KnowledgeTableInfo knowledgeTableInfo){
        try {
            System.out.println(knowledgeTableInfo);
            PageInfo<KnowledgePoint> list = knowledgeService.getPageKnowledgeList(knowledgeTableInfo);
            return new Message(Message.SUCCESS,"查询成功!",list);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"查询失败!",null);
        }
    }

    @RequestMapping(value = "/deleteKnowledge",method = RequestMethod.POST)
    public Message deleteKnowLedge(@RequestBody KnowledgeTableInfo knowledgeTableInfo){
        try {
            knowledgeService.deleteKnowledge(knowledgeTableInfo);
            return new Message(Message.SUCCESS,"删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"删除失败",null);
        }
    }


    @RequestMapping(value = "/updateKnowledge",method = RequestMethod.POST)
    public Message updateKnowLedge(@RequestBody KnowledgeTableInfo knowledgeTableInfo){
        try {
            return new Message(Message.SUCCESS,"修改成功!",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"修改失败!",null);
        }
    }
}
