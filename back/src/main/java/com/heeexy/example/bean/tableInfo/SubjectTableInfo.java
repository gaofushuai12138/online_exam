package com.heeexy.example.bean.tableInfo;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.bean.Subject;

public class SubjectTableInfo extends SelectParams {

    private Subject subject = new Subject();

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SubjectTableInfo{" +
                "subject=" + subject +
                '}';
    }
}
