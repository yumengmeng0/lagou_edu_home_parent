package org.example.service;

import org.example.domain.Role;
import org.example.domain.RoleMenuRelation;
import org.example.domain.RoleMenuVO;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
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


}
