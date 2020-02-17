package com.heeexy.example.bean.tableInfo;

import com.heeexy.example.bean.Question;

public class QuestionTableInfo extends SelectParams {

    private Question question = new Question();

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
