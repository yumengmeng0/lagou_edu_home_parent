package org.example.controller;

import org.example.domain.Course;
import org.example.domain.CourseVO;
import org.example.domain.ResponseResult;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;


/**
 * 课程
 * @author
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAllCourse")
    public ResponseResult findAllCourse(@RequestBody CourseVO courseVO) {
        System.out.println("courseVO.getStatus() = " + courseVO.getStatus());
        // 暂时没有分页
        List<Course> courseList = courseService.findCourseByCondition(courseVO);
        return new ResponseResult(true, 0, "响应成功", courseList);
    }

    /**
     * 根据条件查询课程
     *
     * @param courseVO
     * @return
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO) {
        List<Course> courseList = courseService.findCourseByCondition(courseVO);
        return new ResponseResult(true, 200, "响应成功", courseList);
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

        return new ResponseResult(true, 200, "图片上传成功", map);
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
        if (courseVO.getId() == null) {
            courseService.saveCourseOrTeacher(courseVO);
            return new ResponseResult(true, 200, "新增成功", null);
        } else {
            courseService.updateCourseOrTeacher(courseVO);
            return new ResponseResult(true, 200, "修改成功", null);
        }
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
        return new ResponseResult(true, 200, "根据id查询课程成功", courseVO);
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
        return new ResponseResult(true, 200, "课程状态修改成功", map);
    }

}
