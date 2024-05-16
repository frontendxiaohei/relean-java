package com.ck.edu.api;


import com.ck.edu.entity.subject.OneSubject;
import com.ck.edu.service.EduSubjectService;
import com.ck.edu.utils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/subject")
public class SubjectAdminController {

    @Resource
    private EduSubjectService eduSubjectService;


    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) {
        eduSubjectService.importSubjectData(file, eduSubjectService);
        return R.ok();
    }

    //课程分类列表（树形）
    @GetMapping("getAllSubject")
    public R getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list",list);
    }

}
