package org.example.mapper;

import org.example.domain.Course;
import org.example.domain.CourseSection;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/19
 * @version: 1.0.0
 * @description: 课程内容
 */
public interface CourseContentMapper {

    /**
     * 根据课程id查询课程关联的章节和课时信息
     *
     * @param id
     * @return
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id);

    /**
     * 根据课程id查询课程信息
     *
     * @param id
     * @return
     */
    public Course findCourseByCourseId(Integer id);

    /**
     * 添加章节信息
     *
     * @param section
     */
    public void saveSection(CourseSection section);

    /**
     * 更新章节信息
     *
     * @param section
     */
    public void updateSection(CourseSection section);


}
