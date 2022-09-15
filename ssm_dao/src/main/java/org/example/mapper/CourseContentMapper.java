package org.example.mapper;

import org.example.domain.*;

import java.util.List;

/**
 * 课程内容
 *
 * @author
 */
public interface CourseContentMapper {

    /**
     * 根据课程id查询课程关联的章节和课时信息
     *
     * @param id
     * @return
     */
    List<CourseSection> findSectionAndLessonByCourseId(Integer id);

    /**
     *
     * @param id
     * @return
     */
    List<CourseSection> findSectionAndLessonByCourseId1(Integer id);

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
     * 新建课时信息
     *
     * @param courseLesson
     */
    void saveLesson(CourseLesson courseLesson);

    /**
     * 更新课时信息
     *
     * @param courseLesson
     */
    void updateLesson(CourseLesson courseLesson);

    /**
     * 修改课时状态
     *
     * @param courseLesson
     */
    void updateLessonStatus(CourseLesson courseLesson);


    /**
     * 根据课程和章节id查找课时
     *
     * @param courseId
     * @param sectionId
     * @return
     */
//    List<CourseLesson> findLessonByCourseIdAndSectionId(@Param("courseId") Integer courseId, @Param("sectionId") Integer sectionId);
}
