package org.example.controller;

import org.example.domain.Course;
import org.example.domain.CourseSection;
import org.example.domain.ResponseResult;
import org.example.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/19
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLessonByCourseId")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam("id") Integer id) {
        List<CourseSection> sectionList = courseContentService.findSectionAndLessonByCourseId(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", sectionList);
        return responseResult;
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
        ResponseResult responseResult = new ResponseResult(true, 200, "查询课程信息成功", course);
        return responseResult;
    }

    /**
     * 新增或修改章节信息
     *
     * @param section
     * @return
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection section) {
        ResponseResult responseResult = null;

        if (section.getId() == null) {
            courseContentService.saveSection(section);
            responseResult = new ResponseResult(true, 200, "新增成功", null);
        } else {
            courseContentService.updateSection(section);
            responseResult = new ResponseResult(true, 200, "修改成功", null);
        }

        return responseResult;
    }


}
