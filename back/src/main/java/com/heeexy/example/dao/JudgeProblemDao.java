package com.heeexy.example.dao;

import com.heeexy.example.bean.JudgeProblem;
import com.heeexy.example.bean.tableInfo.JudgeProblemTableInfo;

import java.util.List;

public interface JudgeProblemDao {

    int insertJudgeProblem(JudgeProblemTableInfo judgeProblemTableInfo);

    int deleteJudgeProblem(JudgeProblemTableInfo judgeProblemTableInfo);

    int updateJudgeProblem(JudgeProblemTableInfo judgeProblemTableInfo);

    List<JudgeProblem> getAllJudgeProblems(JudgeProblemTableInfo judgeProblemTableInfo);


}
