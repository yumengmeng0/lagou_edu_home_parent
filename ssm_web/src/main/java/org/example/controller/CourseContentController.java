package org.example.controller;

import org.example.domain.*;
import org.example.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 课程内容
 *
 * @author
 */
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam("courseId") Integer courseId) {
        List<CourseSection> sectionList = courseContentService.findSectionAndLessonByCourseId(courseId);
        return new ResponseResult(true, 200, "响应成功", sectionList);
    }

    /**
     * 根据课程id查询课程信息
     *
     * @param courseId
     * @return
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam("courseId") Integer courseId) {
        Course course = courseContentService.findCourseByCourseId(courseId);
        return new ResponseResult(true, 200, "查询课程信息成功", course);
    }

    /**
     * 新增或修改章节信息
     *
     * @param section
     * @return
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection section) {
        if (section.getId() == null) {
            courseContentService.saveSection(section);
            return new ResponseResult(true, 200, "新增成功", null);
        } else {
            courseContentService.updateSection(section);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }

    /**
     * 修改课时状态
     *
     * @return
     */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(CourseSection courseSection) {
        courseContentService.updateSectionStatus(courseSection);
        return new ResponseResult(true, 200, "修改章节状态成功", null);
    }

    /**
     * 新增或修改课时信息
     *
     * @param courseLesson
     * @return
     */
    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson courseLesson) {
        if (courseLesson.getId() != null) {
            courseContentService.updateLesson(courseLesson);
        } else {
            courseContentService.saveLesson(courseLesson);
        }
        return new ResponseResult(true, 200, "修改或新增课时成功", null);
    }

    /**
     * 更新课时状态
     *
     * @param courseLesson
     * @return
     */
    @RequestMapping("/updateLessonStatus")
    public ResponseResult updateLessonStatus(CourseLesson courseLesson) {
        courseContentService.updateLessonStatus(courseLesson);
        return new ResponseResult(true, 200, "更新课时状态成功", null);
    }


}
