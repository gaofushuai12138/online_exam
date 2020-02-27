package com.heeexy.example.service;

import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.KnowledgePoint;
import com.heeexy.example.bean.tableInfo.KnowledgeTableInfo;

public interface KnowledgeService {


    PageInfo<KnowledgePoint> getPageKnowledgeList(KnowledgeTableInfo knowledgeTableInfo);


    int insertKnowledge(KnowledgeTableInfo knowledgeTableInfo);

    int deleteKnowledge(KnowledgeTableInfo knowledgeTableInfo);
}
