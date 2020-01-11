package com.test;

import com.github.pagehelper.PageInfo;
import com.heeexy.example.MyApplication;
import com.heeexy.example.bean.tableInfo.SysLogTableInfo;
import com.heeexy.example.dao.SysLogDao;
import com.heeexy.example.service.SysLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sound.midi.Soundbank;
import java.util.List;

@SpringBootTest(classes = MyApplication.class)
@RunWith(SpringRunner.class)
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class TestMethod {

    @Autowired
    private SysLogService sysLogService;

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


}
