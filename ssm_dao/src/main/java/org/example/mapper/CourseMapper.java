package org.example.mapper;

import org.example.domain.Course;
import org.example.domain.CourseVO;
import org.example.domain.Teacher;

import java.util.List;

/**
 * @author
 */
public interface CourseMapper {
    /**
     * 多条件（课程名和课程上下架状态）查询
     *
     * @param courseVO
     * @return
     */
    List<Course> findCourseByCondition(CourseVO courseVO);

    /**
     * 新增课程
     *
     * @param course
     */
    void saveCourse(Course course);

    /**
     * 更新课程信息
     *
     * @param course
     */
    void updateCourse(Course course);

    /**
     * 新增老师
     *
     * @param teacher
     */
    void saveTeacher(Teacher teacher);

    /**
     * 更新讲师信息
     *
     * @param teacher
     */
    void updateTeacher(Teacher teacher);

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
     * @param course
     */
    void updateCourseStatus(Course course);
}
