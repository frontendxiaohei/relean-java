package com.ck.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ck.edu.entity.EduSubject;
import com.ck.edu.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * 课程科目(EduSubject)表服务接口
 *
 * @author makejava
 * @since 2024-05-14 17:40:23
 */
public interface EduSubjectService extends IService<EduSubject> {


    void importSubjectData(MultipartFile file, EduSubjectService eduSubjectService);

    //课程分类列表（树形）
    List<OneSubject> getAllOneTwoSubject();
}
