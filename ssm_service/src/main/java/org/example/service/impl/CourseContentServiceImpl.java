package org.example.service.impl;

import org.example.domain.*;
import org.example.mapper.CourseContentMapper;
import org.example.service.CourseContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author
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
        section.setStatus(0);
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
        section.setUpdateTime(new Date());
        courseContentMapper.updateSection(section);
    }

    /**
     * 根据章节id修改章节状态
     *
     * @param courseSection
     */
    @Override
    public void updateSectionStatus(CourseSection courseSection) {
        courseSection.setUpdateTime(new Date());
        courseContentMapper.updateSectionStatus(courseSection);
    }

    /**
     * 新建课时
     *
     * @param courseLesson
     */
    @Override
    public void saveLesson(CourseLesson courseLesson) {
        Date createTime = new Date();
        courseLesson.setCreateTime(createTime);
        courseLesson.setUpdateTime(createTime);
        courseLesson.setStatus(0);
        BeanUtils.copyProperties(courseLesson, courseLesson);
        System.out.println("courseLessonVO = " + courseLesson);
        System.out.println("courseLesson = " + courseLesson);
        courseContentMapper.saveLesson(courseLesson);
    }

    /**
     * 更新课时
     *
     * @param courseLesson
     */
    @Override
    public void updateLesson(CourseLesson courseLesson) {
        courseLesson.setUpdateTime(new Date());
        courseContentMapper.updateLesson(courseLesson);
    }

    /**
     * 更新课时状态
     *
     * @param courseLesson
     */
    @Override
    public void updateLessonStatus(CourseLesson courseLesson) {
        courseLesson.setUpdateTime(new Date());
        courseContentMapper.updateLessonStatus(courseLesson);
    }

}
