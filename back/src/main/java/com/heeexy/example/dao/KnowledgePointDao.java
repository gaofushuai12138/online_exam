package com.heeexy.example.dao;

import com.heeexy.example.bean.KnowledgePoint;
import com.heeexy.example.bean.tableInfo.KnowledgeTableInfo;

import java.util.List;

public interface KnowledgePointDao {

    List<KnowledgePoint> getAllKnowledges(KnowledgeTableInfo knowledgeTableInfo);


    int insertKnowledges(KnowledgeTableInfo knowledgeTableInfo);


    int deleteKnowledges(KnowledgeTableInfo knowledgeTableInfo);



}
