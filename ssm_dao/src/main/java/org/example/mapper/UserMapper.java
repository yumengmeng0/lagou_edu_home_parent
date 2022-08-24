package org.example.mapper;

import org.example.domain.*;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
public interface UserMapper {

    /**
     * 用户分页多条件组合查询
     *
     * @return
     */
    List<User> findAllUserByPage(UserVO userVO);

    /**
     * 用户登录（根据用户名查询具体用户信息）
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 根据用户id查询关联的角色信息
     *
     * @param userId
     * @return
     */
    List<Role> findUserRelationRoleById(Integer userId);

    /**
     * 根据用户id清空中间表
     *
     * @param userId
     */
    void deleteUserContextRole(Integer userId);

    /**
     * 分配角色
     *
     * @param userRoleRelation
     */
    void userContextRole(UserRoleRelation userRoleRelation);

    /**
     * 根据角色id，查询角色拥有的顶级菜单 -1
     *
     * @param ids
     * @return
     */
    List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /**
     * 根据parent id查询子菜单信息
     *
     * @param parentId
     * @return
     */
    List<Menu> findSubMenuByParentId(Integer parentId);

    /**
     * 获取用户拥有的资源权限信息
     *
     * @param ids
     * @return
     */
    List<Resource> findResourceByRoleId(List<Integer> ids);
}
