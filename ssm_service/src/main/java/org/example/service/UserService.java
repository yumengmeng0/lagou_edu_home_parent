package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.*;

import java.util.List;

/**
 * @author
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
     * @param id
     * @return
     */
    List<Role> findUserRelationRoleById(Integer id);

    /**
     * 分配角色
     *
     * @param userVO
     */
    void userContextRole(UserVO userVO);

    /**
     * 获取用户权限信息
     *
     * @param id
     * @return
     */
    ResponseResult getUserPermissions(Integer id);

    /**
     * 修改用户状态
     *
     * @param userVO
     */
    void updateUserStatus(UserVO userVO);

}
