package com.heeexy.example.service;

import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.SysLog;

import java.util.List;

public interface SysLogService {

    Integer addSysLog(String module,String description) throws Exception;

    PageInfo<SysLog> getAllSysLog(Integer pageNum, Integer pageSize) throws Exception;
}
