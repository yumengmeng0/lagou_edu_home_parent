package org.example.service;

import org.example.domain.*;

import java.util.List;

/**
 * @author
 */
public interface RoleService {


    /**
     * 按条件查询所有角色
     *
     * @param role
     * @return
     */
    List<Role> findAllRole(Role role);

    /**
     * 根据角色id查询该角色关联菜单信息的id
     *
     * @param roleId
     * @return
     */
    List<Integer> findMenuByRoleId(Integer roleId);

    /**
     * 为角色分配菜单
     *
     * @param roleMenuVO
     */
    void allocateRoleContextMenu(RoleMenuVO roleMenuVO);

    /**
     * 删除角色
     *
     * @param roleId
     */
    void deleteRole(Integer roleId);

    /**
     * 添加角色
     *
     * @param role
     */
    void saveRole(Role role);

    /**
     * 修改角色
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 为角色分配资源
     *
     * @param resourceVO
     */
    void allocateRoleContextResource(ResourceVO resourceVO);


    /**
     * 根据id查找角色拥有的资源分类和资源信息
     *
     * @param roleId
     * @return
     */
    List<ResourceCategory> findRoleHaveResource(Integer roleId);

}
