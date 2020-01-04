package com.heeexy.example.service.impl;


import com.heeexy.example.bean.SysLog;
import com.heeexy.example.dao.SysLogDao;
import com.heeexy.example.service.SysLogService;
import com.heeexy.example.util.ECache;
import com.heeexy.example.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SysLogServiceImpl implements SysLogService {


    @Autowired
    private SysLogDao sysLogDao;


    @Override
    public Integer addSysLog(String moudle,String description) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        SysLog log = new SysLog();
        String username = ECache.get("username");
        String ip = IPUtils.getIP(request);
        log.setIp(ip);
        log.setMoudle(moudle);
        log.setDescription(description);
        log.setUsername(username);
        LocalDateTime rightNow = LocalDateTime.now();
        String currenttime = rightNow.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss"));
        log.setOperationTime(currenttime);
        return sysLogDao.addSysLog(log);
    }
}
