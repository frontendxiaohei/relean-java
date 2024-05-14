package com.ck.edu.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ck.edu.entity.EduTeacher;
import com.ck.edu.mapper.EduTeacherMapper;
import com.ck.edu.query.TeacherQuery;
import com.ck.edu.service.EduTeacherService;
import com.ck.edu.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {



    @Resource
    private EduTeacherService eduTeacherService;

    @PostMapping("/{page}/{limit}")
    public R pageList(@PathVariable Long page,
                      @PathVariable Long limit,
                      @RequestBody TeacherQuery teacherQuery) {
        Page<EduTeacher> pageParam = new Page<>(page,limit);
        eduTeacherService.pageQuery(pageParam,teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("total",total).data("rows", records);
    }



    @PostMapping("/save")
    public R save(
        @RequestBody EduTeacher teacher){
        eduTeacherService.save(teacher);
        return R.ok();
    }

    @GetMapping("{id}")
    public R getById(
        @PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("item", teacher);
    }

    @PutMapping("{id}")
    public R updateById(
        @PathVariable String id,
        @RequestBody EduTeacher teacher){
        teacher.setId(id);
        eduTeacherService.updateById(teacher);
        return R.ok();
    }



}
