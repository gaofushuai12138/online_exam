package com.heeexy.example.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.SimpleProblem;
import com.heeexy.example.bean.tableInfo.SimpleProblemTableInfo;
import com.heeexy.example.dao.SingleProblemDao;
import com.heeexy.example.service.SimpleProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SimpleProblemServiceImpl implements SimpleProblemService {


    @Autowired
    private SingleProblemDao singleProblemDao;

    @Override
    public int insertSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo) {
        return singleProblemDao.insertSimpleProblem(simpleProblemTableInfo);
    }

    @Override
    public PageInfo<SimpleProblem> getSimpleProblemList(SimpleProblemTableInfo simpleProblemTableInfo) {
        PageHelper.startPage(simpleProblemTableInfo.getPageNum(),simpleProblemTableInfo.getPageSize());
        List<SimpleProblem> simpleProblems = singleProblemDao.getSingleProblemListBysubject(simpleProblemTableInfo);
        PageInfo<SimpleProblem> pageInfo = new PageInfo<>(simpleProblems);
        return pageInfo;
    }

    @Override
    public int deleteSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo) throws Exception{
        Integer id = simpleProblemTableInfo.getSimpleProblem().getId();
        if(Objects.isNull(id)){
            return -1;
        }
        return singleProblemDao.deleteSimpleProblem(simpleProblemTableInfo);
    }

    @Override
    public int updateSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo) throws Exception {
        Integer id = simpleProblemTableInfo.getSimpleProblem().getId();
        if(Objects.isNull(id)){
            return -1;
        }
        return singleProblemDao.updateSimpleProblem(simpleProblemTableInfo);
    }


}
