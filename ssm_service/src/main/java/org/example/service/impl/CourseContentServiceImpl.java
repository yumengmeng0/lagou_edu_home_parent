package org.example.service.impl;

import org.example.domain.Course;
import org.example.domain.CourseSection;
import org.example.mapper.CourseContentMapper;
import org.example.mapper.CourseMapper;
import org.example.service.CourseContentService;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/19
 * @version: 1.0.0
 * @description:
 */
@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    /**
     * 根据课程id查询课程关联的章节和课时信息
     *
     * @param id
     * @return
     */
    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id) {
        return courseContentMapper.findSectionAndLessonByCourseId(id);
    }

    /**
     * 根据课程id查询课程信息
     *
     * @param id
     * @return
     */
    @Override
    public Course findCourseByCourseId(Integer id) {
        return courseContentMapper.findCourseByCourseId(id);
    }

    /**
     * 添加章节信息
     *
     * @param section
     */
    @Override
    public void saveSection(CourseSection section) {
        Date createTime = new Date();
        section.setCreateTime(createTime);
        section.setUpdateTime(createTime);
        courseContentMapper.saveSection(section);
    }

    /**
     * 更新章节信息
     *
     * @param section
     */
    @Override
    public void updateSection(CourseSection section) {
        Date updateTime = new Date();
        section.setUpdateTime(updateTime);
        courseContentMapper.updateSection(section);
    }
}
