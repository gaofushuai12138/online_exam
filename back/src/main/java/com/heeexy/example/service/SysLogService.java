package com.heeexy.example.service;

import com.heeexy.example.bean.SysLog;

public interface SysLogService {

    Integer addSysLog(String module,String description) throws Exception;
}
