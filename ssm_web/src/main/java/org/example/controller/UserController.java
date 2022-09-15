package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.domain.ResponseResult;
import org.example.domain.Role;
import org.example.domain.User;
import org.example.domain.UserVO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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
        return new ResponseResult(true, 200, "分页条件查询用户成功", pageInfo);
    }


    /**
     * 用户登录（根据用户名查询具体用户信息）
     *
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User user1 = userService.login(user);
        if (user1 != null) {
            // 保存用户id和access_token到session中
            HttpSession session = request.getSession();

            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", user1.getId());

            HashMap<String, Object> map = new HashMap<>();
            map.put("access_token", access_token);
            map.put("user_id", user1.getId());

            map.put("user", user1);
            return new ResponseResult(true, 1, "登录成功", map);
        } else {
            return new ResponseResult(true, 400, "用户名或密码错误", null);
        }

    }


    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id) {
        List<Role> roleList = userService.findUserRelationRoleById(id);
        return new ResponseResult(true, 200, "查询分配角色成功", roleList);
    }

    /**
     * 分配角色
     *
     * @param userVO
     */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVO userVO) {
        userService.userContextRole(userVO);
        return new ResponseResult(true, 200, "分配角色成功", null);
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request, Integer id) {
        // 1.获取请求头中的token
        String headerToken = request.getHeader("Authorization");
        // 2.获取session中的access_token
        String accessToken = (String) request.getSession().getAttribute("access_token");
        if (headerToken.equals(accessToken)) {
            Integer userId = (Integer) request.getSession().getAttribute("user_id");
            return userService.getUserPermissions(userId);
        } else {
            return new ResponseResult(true, 400, "获取菜单信息失败", null);
        }
    }

    /**
     * 修改用户状态，ENABLE表示能登录，DISABLE表示不能登录
     *
     * @param userVO
     * @return
     */
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(UserVO userVO) {
        userService.updateUserStatus(userVO);
        return new ResponseResult(true, 200, "更改用户状态成功", userVO.getStatus());
    }

}
