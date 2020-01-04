package com.heeexy.example.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SelectParams {


    private int pageSize;


    private int pageNum;

    @JsonIgnore
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    @JsonIgnore
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }


}
