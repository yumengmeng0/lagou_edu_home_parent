package org.example.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 章节类
 * */
@Data
public class CourseSection {
    //id
    private Integer id;
    //课程id
    private Integer courseId;
    //章节名
    private String sectionName;
    //章节描述
    private String description;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //是否删除
    private Integer isDel;
    //排序
    private Integer orderNum;
    //状态
    private Integer status; // int 默认 0 Integer 默认 null
    //课时集合
    private List<CourseLesson> lessonList;
}
