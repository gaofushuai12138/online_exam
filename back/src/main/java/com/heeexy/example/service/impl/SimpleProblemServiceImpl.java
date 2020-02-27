package com.heeexy.example.service.impl;


import com.heeexy.example.bean.tableInfo.SimpleProblemTableInfo;
import com.heeexy.example.dao.SingleProblemDao;
import com.heeexy.example.service.SimpleProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProblemServiceImpl implements SimpleProblemService {


    @Autowired
    private SingleProblemDao singleProblemDao;

    @Override
    public int insertSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo) {
        return singleProblemDao.insertSimpleProblem(simpleProblemTableInfo);
    }
}
