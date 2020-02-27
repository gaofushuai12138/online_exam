package com.heeexy.example.service;


import com.heeexy.example.bean.tableInfo.SimpleProblemTableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface SimpleProblemService {

    int insertSimpleProblem(SimpleProblemTableInfo simpleProblemTableInfo);


}
