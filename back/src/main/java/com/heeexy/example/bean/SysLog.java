package com.heeexy.example.bean;

import java.util.Date;

public class SysLog {
    private int logId;
    private int userId;
    private String opName;
    private Date opDate;
    private String Label;
    private String username;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", opName='" + opName + '\'' +
                ", opDate=" + opDate +
                ", Label='" + Label + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
