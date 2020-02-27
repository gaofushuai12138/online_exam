package com.test;

import com.github.pagehelper.PageInfo;
import com.heeexy.example.MyApplication;
import com.heeexy.example.bean.Department;
import com.heeexy.example.bean.KnowledgePoint;
import com.heeexy.example.bean.SimpleProblem;
import com.heeexy.example.bean.Subject;
import com.heeexy.example.bean.tableInfo.*;
import com.heeexy.example.dao.KnowledgePointDao;
import com.heeexy.example.dao.SingleProblemDao;
import com.heeexy.example.dao.SubjectDao;
import com.heeexy.example.service.DepartmentService;

import com.heeexy.example.service.SimpleProblemService;
import com.heeexy.example.service.SubjectService;
import com.heeexy.example.service.SysLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest(classes = MyApplication.class)
@RunWith(SpringRunner.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class TestMethod {

    @Autowired
    private SysLogService sysLogService;


    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private SubjectService subjectService;




    @Test
    public void testFindSysLog(){
        SysLogTableInfo syslog = new SysLogTableInfo();
        syslog.getSysLog().setUsername("admin");
        try {
//            System.out.println(sysLogService);
            PageInfo list =  sysLogService.getAllSysLog(syslog);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        System.out.println("2221");
    }


    @Test
    public void testFindDepartmentById(){
        Department department = departmentService.getDepartmentById(1);
        System.out.println(department);
    }



    @Test
    public void testLomBok(){


    }


    @Autowired
    private SingleProblemDao singleProblemDao;

    @Test
    public void testgetsingleProblem(){
        SimpleProblemTableInfo simpleProblemTableInfo = new SimpleProblemTableInfo();
        List list = singleProblemDao.getSingleProblemList(simpleProblemTableInfo);
        System.out.println(list);
    }


    @Test
    public void testgetsingleSubject(){

    }


    @Autowired
    SubjectDao subjectDao;
    @Test
    public void testgetIdByname(){
        int id = subjectDao.getSubjectIdByName("java");
        System.out.println(id);

    }


    @Autowired
    SimpleProblemService simpleProblemService;
    @Test
    public void insertsingleProblem(){
        SimpleProblem simpleProblem = new SimpleProblem();
        simpleProblem.setSubjectId(1);
        simpleProblem.setTitle("gaga");
        simpleProblem.setAnswerA("asaasas");
        simpleProblem.setAnswerB("ssaasas");
        simpleProblem.setAnswerC("dsdsdsdds");
        simpleProblem.setAnswerD("sssas");
        simpleProblem.setDiff(1);
        simpleProblem.setCorrectAnswer("D");
        SimpleProblemTableInfo simpleProblemTableInfo = new SimpleProblemTableInfo();
        simpleProblemTableInfo.setSimpleProblem(simpleProblem);
        simpleProblemService.insertSimpleProblem(simpleProblemTableInfo);

    }


    @Autowired
    KnowledgePointDao knowledgePointDao;

    @Test
    public void testgetKnowledgeList(){
       List list = knowledgePointDao.getAllKnowledges(null);
        System.out.println(list);
    }


    @Test
    public void testUpdateDepartment(){
        Department department = new Department();
        department.setDepartmentId(17);
        department.setDepartmentName("测试234");
        DepartmentTableInfo departmentTableInfo = new DepartmentTableInfo();
        departmentTableInfo.setDepartment(department);
        departmentService.editDepartment(departmentTableInfo);
    }


    @Test
    public void testinsertSubject(){
        try {
            Subject subject = new Subject();
            subject.setSubjectName("c#");
            LocalDateTime rightNow = LocalDateTime.now();
            String currenttime = rightNow.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss"));
            System.out.println(currenttime);
            subject.setUpdateTime(currenttime);
            SubjectTableInfo subjectTableInfo = new SubjectTableInfo();
            subjectTableInfo.setSubject(subject);
            subjectService.insertSubject(subjectTableInfo);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void testdeleteSubject(){
        Subject sub = new Subject();
        sub.setSubjectId(2);
        SubjectTableInfo subjectTableInfo = new SubjectTableInfo();
        subjectTableInfo.setSubject(sub);
        try {
            subjectService.deleteSubject(subjectTableInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testinsertKnowLedge(){
        KnowledgePoint knowledgePoint = new KnowledgePoint();
        knowledgePoint.setSubjectId(1);
        knowledgePoint.setContent("设计模式");
        KnowledgeTableInfo knowledgeTableInfo = new KnowledgeTableInfo();
        knowledgeTableInfo.setKnowledgePoint(knowledgePoint);
        LocalDateTime rightNow = LocalDateTime.now();
        String currenttime = rightNow.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss"));
        knowledgePoint.setUpdateTime(currenttime);
        knowledgePointDao.insertKnowledges(knowledgeTableInfo);
    }
}
