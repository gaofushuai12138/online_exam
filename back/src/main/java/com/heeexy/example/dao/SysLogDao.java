package com.heeexy.example.dao;

import com.heeexy.example.bean.SysLog;
import com.heeexy.example.bean.tableInfo.SysLogTableInfo;

import java.util.List;

public interface SysLogDao {

    Integer addSysLog(SysLog sysLog);

    List<SysLog> getAllSysLog(SysLogTableInfo sysLog);
}
