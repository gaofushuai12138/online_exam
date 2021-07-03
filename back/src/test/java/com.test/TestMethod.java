package com.test;

import com.github.pagehelper.PageInfo;
import com.hankcs.hanlp.HanLP;
import com.heeexy.example.MyApplication;
import com.heeexy.example.bean.*;
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
    private JudgeProblem judgeProblem;




}
