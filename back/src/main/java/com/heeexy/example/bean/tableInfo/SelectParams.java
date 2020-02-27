package com.heeexy.example.bean.tableInfo;

import com.alibaba.fastjson.JSONObject;

public class SelectParams  {

    private String startTime;

    private String endTime;

    private int pageSize;

    private int pageNum;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "SelectParams{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                '}';
    }
}
