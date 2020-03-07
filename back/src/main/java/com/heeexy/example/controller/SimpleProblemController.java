package com.heeexy.example.controller;


import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Message;
import com.heeexy.example.bean.SimpleProblem;
import com.heeexy.example.bean.Subject;
import com.heeexy.example.bean.tableInfo.SimpleProblemTableInfo;
import com.heeexy.example.service.SimpleProblemService;
import com.heeexy.example.service.SubjectService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/SimpleProblem")
public class SimpleProblemController {


    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SimpleProblemService simpleProblemService;


    @RequestMapping(value = "/getSimpleProblemList",method = RequestMethod.POST)
    public Message getSimpleProblemList(@RequestBody SimpleProblemTableInfo simpleProblemTableInfo){
        try {
//            List<Subject> subjects = subjectService.getSubjectList();
            PageInfo<SimpleProblem> pageInfo = simpleProblemService.getSimpleProblemList(simpleProblemTableInfo);
            return new Message(Message.SUCCESS,"查询成功!",pageInfo);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"查询失败!",null);
        }
    }


    @RequestMapping(value = "/deletesingleProblem",method = RequestMethod.POST)
    public Message deleteSimpleProblem(@RequestBody SimpleProblemTableInfo simpleProblemTableInfo){
        try {
            int resultOfdel = simpleProblemService.deleteSimpleProblem(simpleProblemTableInfo);
            if(resultOfdel != -1){
                return new Message(Message.SUCCESS,"删除成功",null);
            }else {
                return new Message(Message.FAILURE,"删除失败",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"删除失败!",null);
        }
    }

    @RequestMapping(value = "/insertSimpleProblem",method = RequestMethod.POST)
    public Message insertSimpleProblem(@RequestBody SimpleProblemTableInfo simpleProblemTableInfo){
        try {
            simpleProblemService.insertSimpleProblem(simpleProblemTableInfo);
            return new Message(Message.SUCCESS,"插入成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"插入失败!",null);
        }
    }


    @RequestMapping(value = "/updateSimpleProblm",method = RequestMethod.POST )
    public Message updateSimpleProblem(@RequestBody SimpleProblemTableInfo simpleProblemTableInfo){
        try {
            int resOfUpdate = simpleProblemService.updateSimpleProblem(simpleProblemTableInfo);
            if(resOfUpdate != -1){
                return new Message(Message.SUCCESS,"修改成功!",null);
            }else {
                return new Message(Message.FAILURE,"修改失败!",null);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"修改失败",null);
        }
    }


    @RequestMapping(value = "/importSimpleProblem",method = RequestMethod.POST)
    public Message uplodExcelForSimplePromblemData(@RequestPart("file")MultipartFile file){
        try {
            XSSFWorkbook workbook = null;
            workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
//          循环获取工作表的数据
            for(int i = 0;i < sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i + 1);
                Cell cell = row.getCell(0);
                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
                Cell cell3 = row.getCell(3);
                Cell cell4 = row.getCell(4);
                Cell cell5 = row.getCell(5);
                Cell cell6 = row.getCell(6);
                Cell cell7 = row.getCell(7);
                String subjectnamme = cell.toString();
                String title = cell1.toString();
                String AnswerA = cell2.toString();
                String AnswerB = cell3.toString();
                String AnswerC = cell4.toString();
                String AnswerD = cell5.toString();
                int diff = (int)cell6.getNumericCellValue();
                String correctAnswer  = cell7.toString();
                int subjectId = subjectService.getsubjectIdByName(subjectnamme);
                SimpleProblem simpleProblem = new SimpleProblem();
                simpleProblem.setSubjectId(subjectId);
                simpleProblem.setTitle(title);
                simpleProblem.setAnswerA(AnswerA);
                simpleProblem.setAnswerB(AnswerB);
                simpleProblem.setAnswerC(AnswerC);
                simpleProblem.setAnswerD(AnswerD);
                simpleProblem.setCorrectAnswer(correctAnswer);
                simpleProblem.setDiff(diff);
                SimpleProblemTableInfo simpleProblemTableInfo = new SimpleProblemTableInfo();
                simpleProblemTableInfo.setSimpleProblem(simpleProblem);
                simpleProblemService.insertSimpleProblem(simpleProblemTableInfo);
            }
            return new Message(Message.SUCCESS,"上传成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Message(Message.FAILURE,"上传失败",null);
        }
    }
}
