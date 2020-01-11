package com.heeexy.example.bean.tableInfo;

import com.heeexy.example.bean.SysLog;

public class SysLogTableInfo extends SelectParams {
    private SysLog sysLog = new SysLog();

    public SysLog getSysLog() {
        return sysLog;
    }

    public void setSysLog(SysLog sysLog) {
        this.sysLog = sysLog;
    }

    @Override
    public String toString() {
        return "SysLogTableInfo{" +
                "sysLog=" + sysLog +
                '}';
    }
}
