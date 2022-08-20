package org.example.service;

import org.example.domain.Course;
import org.example.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/17
 * @version: 1.0.0
 * @description:
 */
public interface CourseService {

    /**
     * 多条件（课程名和课程上下架状态）查询
     *
     * @param courseVo
     * @return
     */
    public List<Course> findCourseByCondition(CourseVO courseVo);

    /**
     * 保存课程及教师信息
     *
     * @param courseVo
     */
    public void saveCourseOrTeacher(CourseVO courseVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 更新课程及讲师信息
     *
     * @param courseVo
     */
    public void updateCourseOrTeacher(CourseVO courseVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据课程id查询课程和讲师信息
     *
     * @param id
     * @return
     */
    public CourseVO findCourseById(Integer id);

    /**
     * 根据课程id修改课程状态
     * @param id
     * @param status
     */
    public void updateCourseStatus(Integer id, Integer status);

}
