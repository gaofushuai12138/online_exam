package com.heeexy.example.bean.tableInfo;

import com.heeexy.example.bean.KnowledgePoint;

public class KnowledgeTableInfo extends SelectParams{

    private KnowledgePoint knowledgePoint = new KnowledgePoint();

    public KnowledgePoint getKnowledgePoint() {
        return knowledgePoint;
    }

    public void setKnowledgePoint(KnowledgePoint knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }
}
