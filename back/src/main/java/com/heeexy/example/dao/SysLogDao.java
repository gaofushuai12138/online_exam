package com.heeexy.example.dao;

import com.heeexy.example.bean.SysLog;

import java.util.List;

public interface SysLogDao {

    Integer addSysLog(SysLog sysLog);

    List<SysLog> getAllSysLog();
}
