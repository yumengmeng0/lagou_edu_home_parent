package org.example.service;

import com.github.pagehelper.PageInfo;
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
     * 分页查询所有检测列表
     *
     * @param courseVO
     * @return
     */
    PageInfo<Course> findAllCourseByPage(CourseVO courseVO);

    /**
     * 多条件（课程名和课程上下架状态）查询
     *
     * @param courseVO
     * @return
     */
    List<Course> findCourseByCondition(CourseVO courseVO);

    /**
     * 保存课程及教师信息
     *
     * @param courseVO
     */
    void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 更新课程及讲师信息
     *
     * @param courseVO
     */
    void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据课程id查询课程和讲师信息
     *
     * @param id
     * @return
     */
    CourseVO findCourseById(Integer id);

    /**
     * 根据课程id修改课程状态
     *
     * @param id
     * @param status
     */
    void updateCourseStatus(Integer id, Integer status);

}
