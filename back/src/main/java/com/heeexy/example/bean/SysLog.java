package com.heeexy.example.bean;

import java.io.Serializable;

public class SysLog implements Serializable {
    private int logid;

    private String module;

    private String description;

    private String ip;

    private String username;

    private String  operationTime;

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getModule() {
        return module;
    }

    public void setMoudle(String moudle) {
        this.module = moudle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "logid=" + logid +
                ", moudle='" + module + '\'' +
                ", description='" + description + '\'' +
                ", ip='" + ip + '\'' +
                ", username='" + username + '\'' +
                ", operationTime='" + operationTime + '\'' +
                '}';
    }
}
