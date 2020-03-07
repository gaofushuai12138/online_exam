package com.heeexy.example.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.SimpleProblem;
import com.heeexy.example.bean.tableInfo.SimpleProblemTableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface SimpleProblemService {

    int insertSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo);

    PageInfo<SimpleProblem> getSimpleProblemList(SimpleProblemTableInfo simpleProblemTableInfo);

    int deleteSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo) throws Exception;

    int updateSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo) throws  Exception;


}
