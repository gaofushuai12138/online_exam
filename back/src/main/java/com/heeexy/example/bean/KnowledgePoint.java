package com.heeexy.example.bean;


import lombok.Data;

@Data
public class KnowledgePoint {

    private Integer id;

    private String content;

    private Integer subjectId;

    private Subject subject;

    private String updateTime;

}
