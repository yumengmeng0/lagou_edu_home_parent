package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.domain.ResponseResult;
import org.example.domain.User;
import org.example.domain.UserVO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页条件查询用户
     *
     * @param userVO
     * @return
     */
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO) {
        System.out.println("userVO = " + userVO);
        PageInfo<User> pageInfo = userService.findAllUserByPage(userVO);
        ResponseResult responseResult = new ResponseResult(true, 200, "分页条件查询用户成功", pageInfo);
        return responseResult;
    }

}
