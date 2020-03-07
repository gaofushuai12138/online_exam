package com.heeexy.example.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.JudgeProblem;
import com.heeexy.example.bean.tableInfo.JudgeProblemTableInfo;
import com.heeexy.example.dao.JudgeProblemDao;
import com.heeexy.example.service.JudgeProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JudgeProblemServiceImpl implements JudgeProblemService {


    @Autowired
    private JudgeProblemDao judgeProblemDao;

    @Override
    public int insertJudgeProblem(JudgeProblemTableInfo judgeProblemTableInfo) {
        return judgeProblemDao.insertJudgeProblem(judgeProblemTableInfo);
    }

    @Override
    public int deleteJudgeProblem(JudgeProblemTableInfo judgeProblemTableInfo) {
        Integer id = judgeProblemTableInfo.getJudgeProblem().getId();
        if(Objects.isNull(id)){
            return -1;
        }
        return judgeProblemDao.deleteJudgeProblem(judgeProblemTableInfo);
    }

    @Override
    public int updateJudgeProblem(JudgeProblemTableInfo judgeProblemTableInfo) {
        Integer id = judgeProblemTableInfo.getJudgeProblem().getId();
        if(Objects.isNull(id)){
            return -1;
        }
        return judgeProblemDao.updateJudgeProblem(judgeProblemTableInfo);
    }

    @Override
    public PageInfo<JudgeProblem> getJudgeProblemList(JudgeProblemTableInfo judgeProblemTableInfo) {
        PageHelper.startPage(judgeProblemTableInfo.getPageNum(),judgeProblemTableInfo.getPageSize());
        List<JudgeProblem> judgeProblems = judgeProblemDao.getAllJudgeProblems(judgeProblemTableInfo);
        PageInfo<JudgeProblem> pageInfo = new PageInfo<>(judgeProblems);
        return pageInfo;
    }
}
