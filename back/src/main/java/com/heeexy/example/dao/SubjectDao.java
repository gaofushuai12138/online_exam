package com.heeexy.example.dao;

import com.heeexy.example.bean.Subject;
import com.heeexy.example.bean.tableInfo.SubjectTableInfo;

import java.util.List;

public interface SubjectDao {

    public int insertSubject(SubjectTableInfo subject);

    public int deleteSubject(SubjectTableInfo subject);

    List<Subject> getAllSubject(SubjectTableInfo subjectTableInfo);

    int updateSubject(SubjectTableInfo subjectTableInfo);

    int getSubjectIdByName(String name);

}
