package com.heeexy.example.bean;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heeexy.example.bean.tableInfo.SubjectTableInfo;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

@Data
public class Subject{

    private Integer subjectId;

    private String subjectName;

    private String createTime;

    private String updateTime;

    public String toJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
            result =  objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
