package com.heeexy.example.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudgeProblem {

    private Integer id;

    private Integer subjectId;

    private Subject subject;

    private Integer chapterId;

    private KnowledgePoint knowledgePoint;

    private String title;

    private Integer answer;

    private Integer correctAnswer;

    private Integer score;

    private int diff;
}
