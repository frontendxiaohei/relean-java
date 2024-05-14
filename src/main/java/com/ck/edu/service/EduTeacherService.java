package com.ck.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ck.edu.entity.EduTeacher;
import com.ck.edu.query.TeacherQuery;

public interface EduTeacherService extends IService<EduTeacher> {


    void pageQuery(Page<EduTeacher> pageParams, TeacherQuery teacherQuery);

}
