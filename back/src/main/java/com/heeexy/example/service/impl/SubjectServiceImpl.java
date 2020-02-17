package com.heeexy.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Subject;
import com.heeexy.example.bean.SysLog;
import com.heeexy.example.bean.tableInfo.SubjectTableInfo;
import com.heeexy.example.dao.SubjectDao;
import com.heeexy.example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {


    @Autowired
    private SubjectDao subjectDao;

    @Override
    public int insertSubject(SubjectTableInfo subjectTableInfo) {
        LocalDateTime rightNow = LocalDateTime.now();
        String currenttime = rightNow.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm:ss"));
        subjectTableInfo.getSubject().setUpdateTime(currenttime);
        return subjectDao.insertSubject(subjectTableInfo);
    }

    @Override
    public int deleteSubject(SubjectTableInfo subjectTableInfo) throws Exception {
        return subjectDao.deleteSubject(subjectTableInfo);
    }

    @Override
    public int updateSubject(SubjectTableInfo subjectTableInfo) throws Exception {
         return subjectDao.updateSubject(subjectTableInfo);
    }

    @Override
    public PageInfo<Subject> getAllSubject(SubjectTableInfo subjectTableInfo) throws Exception {
        PageHelper.startPage(subjectTableInfo.getPageNum(),subjectTableInfo.getPageSize());
        List<Subject> subjects = subjectDao.getAllSubject(subjectTableInfo);
        PageInfo<Subject> pageInfo = new PageInfo<>(subjects);
        return pageInfo;
    }
}
