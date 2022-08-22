package org.example.service.impl;

import org.example.domain.Role;
import org.example.domain.RoleMenuRelation;
import org.example.domain.RoleMenuVO;
import org.example.mapper.RoleMapper;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;

    /**
     * 按条件查询所有角色
     *
     * @param role
     * @return
     */
    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    /**
     * 根据角色id查询该角色关联菜单信息的id
     *
     * @param roleId
     * @return
     */
    @Override
    public List<Integer> findMenuByRoleId(Integer roleId) {
        return roleMapper.findMenuByRoleId(roleId);
    }

    /**
     * 为角色分配菜单
     *
     * @param roleMenuVO
     */
    @Override
    public void allocateRoleContextMenu(RoleMenuVO roleMenuVO) {

        Integer roleId = roleMenuVO.getRoleId();
        // 清空中间表关联表
        roleMapper.deleteRoleContextMenu(roleId);

        for (Integer menuId : roleMenuVO.getMenuIdList()) {
            RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
            roleMenuRelation.setMenuId(menuId);
            roleMenuRelation.setRoleId(roleId);

            Date createdTime = new Date();
            roleMenuRelation.setCreatedTime(createdTime);
            roleMenuRelation.setUpdatedTime(createdTime);
            roleMenuRelation.setCreatedBy("system");
            roleMenuRelation.setUpdatedBy("system");

            roleMapper.allocateRoleContextMenu(roleMenuRelation);
        }


    }

    /**
     * 删除角色
     *
     * @param roleId
     */
    @Override
    public void deleteRole(Integer roleId) {
        roleMapper.deleteRoleContextMenu(roleId); // 根据roleId清空中间表
        roleMapper.deleteRole(roleId);
    }
}
