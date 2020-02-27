package com.heeexy.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.KnowledgePoint;
import com.heeexy.example.bean.tableInfo.KnowledgeTableInfo;
import com.heeexy.example.dao.KnowledgePointDao;
import com.heeexy.example.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class KnowledgeServiceImpl implements KnowledgeService {


    @Autowired
    private KnowledgePointDao knowledgePointDao;



    @Override
    public PageInfo<KnowledgePoint> getPageKnowledgeList(KnowledgeTableInfo knowledgeTableInfo) {
        String orderBy = "subjectId" + " desc";
        PageHelper.startPage(knowledgeTableInfo.getPageNum(),knowledgeTableInfo.getPageSize(),orderBy);
        List<KnowledgePoint> list = knowledgePointDao.getAllKnowledges(knowledgeTableInfo);
        PageInfo<KnowledgePoint> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insertKnowledge(KnowledgeTableInfo knowledgeTableInfo) {
        LocalDateTime rightNow = LocalDateTime.now();
        String currenttime = rightNow.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss"));
        knowledgeTableInfo.getKnowledgePoint().setUpdateTime(currenttime);
        knowledgePointDao.insertKnowledges(knowledgeTableInfo);
        return 0;
    }

    @Override
    public int deleteKnowledge(KnowledgeTableInfo knowledgeTableInfo) {
        return knowledgePointDao.deleteKnowledges(knowledgeTableInfo);
    }
}
