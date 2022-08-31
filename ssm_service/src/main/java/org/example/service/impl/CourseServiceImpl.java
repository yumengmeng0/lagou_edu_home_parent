package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.example.domain.Course;
import org.example.domain.CourseVO;
import org.example.domain.Teacher;
import org.example.mapper.CourseMapper;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/17
 * @version: 1.0.0
 * @description:
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 分页查询所有检测列表
     *
     * @param courseVO
     * @return
     */
    @Override
    public PageInfo<Course> findAllCourseByPage(CourseVO courseVO) {

        System.out.println("courseVO = " + courseVO);
        PageHelper.startPage(courseVO.getCurrentPage(), courseVO.getPageSize());
        List<Course> courseList = courseMapper.findCourseByCondition(courseVO); // 复用按条件查询的
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        return pageInfo;
    }

    /**
     * 多条件（课程名和课程上下架状态）查询
     *
     * @param courseVO
     * @return
     */
    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        System.out.println("CourseServiceImpl courseVO.getStatus() = " + courseVO.getStatus());
        return courseMapper.findCourseByCondition(courseVO);
    }

    /**
     * 保存课程或教师信息
     *
     * @param courseVO
     */
    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);

        // 补全课程信息
        Date createTime = new Date();

        course.setCreateTime(createTime);
        course.setUpdateTime(createTime);

        courseMapper.saveCourse(course);

        int courseId = course.getId();

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        teacher.setCreateTime(createTime);
        teacher.setUpdateTime(createTime);
        teacher.setCourseId(courseId);
        teacher.setIsDel(0);

        System.out.println("teacher = " + teacher);
        courseMapper.saveTeacher(teacher);
    }

    /**
     * 更新课程及讲师信息
     *
     * @param courseVO
     */
    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);

        Date updateTime = new Date();
        course.setUpdateTime(updateTime);
        courseMapper.updateCourse(course);

        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(updateTime);
        courseMapper.updateTeacher(teacher);

    }

    /**
     * 根据课程id查询课程和讲师信息
     *
     * @param id
     * @return
     */
    @Override
    public CourseVO findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    /**
     * 根据课程id修改课程状态
     *
     * @param id
     * @param status
     */
    @Override
    public void updateCourseStatus(Integer id, Integer status) {
        Course course = new Course();
        course.setId(id);
        course.setStatus(status);
        Date updateTime = new Date();
        course.setUpdateTime(updateTime);
        courseMapper.updateCourseStatus(course);
    }
}
