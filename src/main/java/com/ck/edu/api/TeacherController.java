package com.ck.edu.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ck.edu.entity.EduTeacher;
import com.ck.edu.mapper.EduTeacherMapper;
import com.ck.edu.query.TeacherQuery;
import com.ck.edu.service.EduTeacherService;
import com.ck.edu.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import java.util.List;

@RestController
@CrossOrigin
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
        boolean save = eduTeacherService.save(teacher);
        if(save) {
            return R.ok();
        } else {
            return R.error();
        }
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

    @DeleteMapping("{id}")
    public R delById(
            @PathVariable String id){
        boolean b = eduTeacherService.removeById(id);
        if(b) {
            return R.ok();
        } else {
            return R.error();
        }
    }







}
