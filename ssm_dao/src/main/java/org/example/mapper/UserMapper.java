package org.example.mapper;

import org.example.domain.*;

import java.util.List;

/**
 * @author
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
     * @param id
     * @return
     */
    List<Role> findUserRelationRoleById(Integer id);

    /**
     * 根据用户id清空中间表
     *
     * @param id
     */
    void deleteUserContextRole(Integer id);

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

    /**
     * 修改用户状态
     *
     * @param userVO
     */
    void updateUserStatus(UserVO userVO);
}
