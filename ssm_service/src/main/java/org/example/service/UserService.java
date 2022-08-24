package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.*;

import java.util.List;


/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
public interface UserService {

    /**
     * 用户分页多条件组合查询
     *
     * @return
     */
    PageInfo<User> findAllUserByPage(UserVO userVO);

    /**
     * 用户登录（根据用户名查询具体用户信息）
     *
     * @param user
     * @return
     */
    User login(User user) throws Exception;

    /**
     * 根据用户id查询关联的角色信息
     *
     * @param userId
     * @return
     */
    List<Role> findUserRelationRoleById(Integer userId);

    /**
     * 分配角色
     *
     * @param userVO
     */
    void userContextRole(UserVO userVO);

    /**
     * 获取用户权限信息
     *
     * @param userId
     * @return
     */
    ResponseResult getUserPermissions(Integer userId);

}
