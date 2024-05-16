package com.ck.edu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程科目(EduSubject)实体类
 *
 * @author makejava
 * @since 2024-05-14 17:40:23
 */

@Data
public class EduSubject implements Serializable {
    private static final long serialVersionUID = -27969994916723445L;
    /**
     * 课程类别ID
     */
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 类别名称
     */
    private String title;
    /**
     * 父ID
     */
    private String parentId;
    /**
     * 排序字段
     */
    private Long sort;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtCreate;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}

