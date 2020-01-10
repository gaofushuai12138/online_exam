package com.heeexy.example.service;

import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.SysLog;
import com.heeexy.example.bean.tableInfo.SysLogTableInfo;

public interface SysLogService {

    Integer addSysLog(String module,String description) throws Exception;

    PageInfo<SysLog> getAllSysLog(SysLogTableInfo sysLog) throws Exception;
}
