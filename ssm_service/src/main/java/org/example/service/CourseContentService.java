package org.example.service;

import org.example.domain.Course;
import org.example.domain.CourseLesson;
import org.example.domain.CourseSection;

import java.util.List;

/**
 * @author
 */
public interface CourseContentService {
    /**
     * 根据课程id查询课程关联的章节和课时信息
     *
     * @param id
     * @return
     */
    List<CourseSection> findSectionAndLessonByCourseId(Integer id);

    /**
     * 根据课程id查询课程信息
     *
     * @param id
     * @return
     */
    Course findCourseByCourseId(Integer id);

    /**
     * 添加章节信息
     *
     * @param section
     */
    void saveSection(CourseSection section);

    /**
     * 更新章节信息
     *
     * @param section
     */
    void updateSection(CourseSection section);

    /**
     * 根据章节id修改章节状态
     *
     * @param courseSection
     */
    void updateSectionStatus(CourseSection courseSection);

    /**
     * 新建课时
     *
     * @param courseLesson
     */
    void saveLesson(CourseLesson courseLesson);

    /**
     * 更新课时
     *
     * @param courseLesson
     */
    void updateLesson(CourseLesson courseLesson);

    /**
     * 更新课时状态
     *
     * @param courseLesson
     */
    void updateLessonStatus(CourseLesson courseLesson);
}
