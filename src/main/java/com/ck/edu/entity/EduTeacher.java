package com.ck.edu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 讲师(EduTeacher)实体类
 *
 * @author makejava
 * @since 2024-05-14 14:04:21
 */
@Data
public class EduTeacher {

    /**
     * 讲师ID
     */
    private String id;
    /**
     * 讲师姓名
     */
    private String name;
    /**
     * 讲师简介
     */
    private String intro;
    /**
     * 讲师资历,一句话说明讲师
     */
    private String career;
    /**
     * 头衔 1高级讲师 2首席讲师
     */
    private Long level;
    /**
     * 讲师头像
     */
    private String avatar;
    /**
     * 排序
     */
    private Long sort;
    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    private Long isDeleted;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}

