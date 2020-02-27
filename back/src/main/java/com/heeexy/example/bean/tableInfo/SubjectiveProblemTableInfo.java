package com.heeexy.example.bean.tableInfo;

import com.heeexy.example.bean.SubjectiveProblem;

public class SubjectiveProblemTableInfo extends SelectParams{

    private SubjectiveProblem subjectiveProblem = new SubjectiveProblem();

    public SubjectiveProblem getSubjectiveProblem() {
        return subjectiveProblem;
    }

    public void setSubjectiveProblem(SubjectiveProblem subjectiveProblem) {
        this.subjectiveProblem = subjectiveProblem;
    }
}
