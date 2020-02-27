package com.heeexy.example.bean;


import lombok.Data;

@Data
public class SimpleProblem {

    private Integer id;

    private int subjectId;

    private Subject subject;

    private String title;

    private String AnswerA;

    private String AnswerB;

    private String AnswerC;

    private String AnswerD;

    private String correctAnswer;   //正确答案

    private Integer Diff;      //试题难度
}
