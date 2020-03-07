package com.heeexy.example.controller;


import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.JudgeProblem;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.tableInfo.JudgeProblemTableInfo;
import com.heeexy.example.dao.JudgeProblemDao;
import com.heeexy.example.service.JudgeProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/JudgeProblem")
public class JudgeProblemController {


    @Autowired
    private JudgeProblemService judgeProblemService;


    @RequestMapping(value = "/insertJudgeProblem",method = RequestMethod.POST)
    public Message insertJudgeProblem(@RequestBody JudgeProblemTableInfo judgeProblemTableInfo){
        try {
            judgeProblemService.insertJudgeProblem(judgeProblemTableInfo);
            return new Message(Message.SUCCESS,"插入成功!",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"插入失败!",null);
        }
    }

    @RequestMapping(value = "/updateJudgeProblem",method = RequestMethod.POST)
    public Message updateJudgeProblem(@RequestBody JudgeProblemTableInfo judgeProblemTableInfo){
        try {
            int resOfUpdate = judgeProblemService.updateJudgeProblem(judgeProblemTableInfo);
            if(resOfUpdate == -1){
                return new Message(Message.FAILURE,"修改失败!",null);
            }else {
                return new Message(Message.SUCCESS,"修改成功!",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"修改失败!",null);
        }
    }


    @RequestMapping(value = "/getJudgeProblemList",method = RequestMethod.POST)
    public Message getJudgeProblemList(@RequestBody JudgeProblemTableInfo judgeProblemTableInfo){
        try {
            PageInfo<JudgeProblem> pageInfo = judgeProblemService.getJudgeProblemList(judgeProblemTableInfo);
            return new Message(Message.SUCCESS,"查找成功!",pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"查找失败!",null);
        }
    }
}
