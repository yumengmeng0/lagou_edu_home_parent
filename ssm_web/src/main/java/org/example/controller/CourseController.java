package org.example.controller;

import org.example.domain.Course;
import org.example.domain.CourseVO;
import org.example.domain.ResponseResult;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/17
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 根据条件查询课程
     *
     * @param courseVo
     * @return
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVo) {
        List<Course> courseList = courseService.findCourseByCondition(courseVo);
        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseList);
        return responseResult;
    }


    /**
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/courseUpload")
    public ResponseResult courseUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException();
        }

        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("realPath = " + realPath);
        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));
        System.out.println("substring = " + substring);

        String originalFilename = file.getOriginalFilename();

        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
        String uploadPath = substring + "upload\\";

        File filePath = new File(uploadPath, newFileName);

        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录 = " + filePath);
        }

        file.transferTo(filePath);

        HashMap<String, String> map = new HashMap<>();
        map.put("fileName", newFileName);
        map.put("filePath", "http://localhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);
        return responseResult;
    }

    /**
     * 新增课程及讲师信息
     * 新增和修改课程信息要写在一个方法中
     *
     * @param courseVO
     * @return
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        ResponseResult responseResult = null;

        if (courseVO.getId() == null) {
            courseService.saveCourseOrTeacher(courseVO);
            responseResult = new ResponseResult(true, 200, "新增成功", null);
        } else {
            courseService.updateCourseOrTeacher(courseVO);
            responseResult = new ResponseResult(true, 200, "修改成功", null);
        }

        return responseResult;
    }

    /**
     * 根据id查找课程信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(@RequestParam("id") Integer id) {
        CourseVO courseVO = courseService.findCourseById(id);

        ResponseResult responseResult = new ResponseResult(true, 200, "根据id查询课程成功", courseVO);
        return responseResult;
    }

    /**
     * 修改课程上下架状态
     *
     * @param id
     * @return
     */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam("id") Integer id, @RequestParam("status") Integer status) {
        courseService.updateCourseStatus(id, status);

        HashMap<String, Object> map = new HashMap<>();
        map.put("status", status);

        ResponseResult responseResult = new ResponseResult(true, 200, "课程状态修改成功", map);
        return responseResult;

    }

}
