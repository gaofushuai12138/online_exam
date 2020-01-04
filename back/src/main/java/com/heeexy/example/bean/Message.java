package com.heeexy.example.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Message {
    public static int SUCCESS = 1;
    public static int FAILURE = 0;
    public static int ERROR = -1;
    private int status;
    private String message;
    private Object result;

    /**
     *
     * @return
     */

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Message(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", result=" + result +
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
