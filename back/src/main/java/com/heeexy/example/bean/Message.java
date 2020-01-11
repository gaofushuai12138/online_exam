package com.heeexy.example.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Message {
    public static int SUCCESS = 100;
    public static int FAILURE = 0;
    public static int ERROR = -1;
    private int code;
    private String msg;
    private Object info;

    /**
     *
     * @return
     */

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object result) {
        this.info = result;
    }

    public Message(int status, String message, Object result) {
        this.code = status;
        this.msg = message;
        this.info = result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + code +
                ", message='" + msg + '\'' +
                ", result=" + info +
                '}';
    }

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
