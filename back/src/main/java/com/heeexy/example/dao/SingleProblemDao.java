package com.heeexy.example.dao;

import com.heeexy.example.bean.SimpleProblem;
import com.heeexy.example.bean.tableInfo.SimpleProblemTableInfo;

import java.util.List;

public interface SingleProblemDao {

    List<SimpleProblem> getSingleProblemListBysubject(SimpleProblemTableInfo simpleProblemTableInfo);


    List<SimpleProblem> getSingleProblemList(SimpleProblemTableInfo simpleProblemTableInfo);


    int insertSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo);
}
