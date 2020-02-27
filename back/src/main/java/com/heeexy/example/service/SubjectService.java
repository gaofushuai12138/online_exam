package com.heeexy.example.service;

import com.github.pagehelper.PageInfo;
import com.heeexy.example.bean.Subject;
import com.heeexy.example.bean.tableInfo.SubjectTableInfo;

import java.util.List;

public interface SubjectService {

    int insertSubject(SubjectTableInfo subjectTableInfo) throws Exception;

    int deleteSubject(SubjectTableInfo subjectTableInfo) throws Exception;

    int updateSubject(SubjectTableInfo subjectTableInfo) throws Exception;

    PageInfo<Subject> getAllSubject(SubjectTableInfo subjectTableInfo) throws Exception;

    int getsubjectIdByName(String name) throws Exception;

    List<Subject> getSubjectList();
}
