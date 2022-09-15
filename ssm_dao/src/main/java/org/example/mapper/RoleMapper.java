package org.example.mapper;


import org.example.domain.*;

import java.util.List;

/**
 * @author
 */
public interface RoleMapper {

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
     * @param roleId
     * @return
     */
    List<Resource> findResourceListByRoleId(Integer roleId);

    /**
     * 根据角色id清空中间表关联关系
     *
     * @param roleId
     */
    void deleteRoleContextMenu(Integer roleId);

    /**
     * 为角色分配菜单
     *
     * @param roleMenuRelation
     */
    void allocateRoleContextMenu(RoleMenuRelation roleMenuRelation);

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
     * 清空角色表与资源表的关系
     *
     * @param roleId
     */
    void deleteRoleContextResourceByRoleId(Integer roleId);

    /**
     * 为角色分配资源
     *
     * @param roleResourceRelation
     */
    void allocateRoleContextResource(RoleResourceRelation roleResourceRelation);

    /**
     * 根据资源id删除中间表
     *
     * @param resourceId
     */
    void deleteRoleContextResource(Integer resourceId);


    /**
     * 根据id查询角色拥有的资源分类数据
     *
     * @param roleId
     * @return
     */
    List<Resource> findRoleHaveResource(Integer roleId);

    /**
     * 根据id查询角色拥有的资源数据
     *
     * @param roleId
     * @return
     */
    List<ResourceCategory> findRoleHaveResourceCategory(Integer roleId);

}
