package com.heeexy.example.bean;

public class SysLog  {
    private int logid;

    private String moudle;

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

    public String getMoudle() {
        return moudle;
    }

    public void setMoudle(String moudle) {
        this.moudle = moudle;
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
                ", moudle='" + moudle + '\'' +
                ", description='" + description + '\'' +
                ", ip='" + ip + '\'' +
                ", username='" + username + '\'' +
                ", operationTime='" + operationTime + '\'' +
                '}';
    }
}
