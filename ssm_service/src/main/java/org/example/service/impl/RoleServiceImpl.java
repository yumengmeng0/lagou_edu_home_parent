package org.example.service.impl;

import org.example.domain.*;
import org.example.mapper.ResourceCategoryMapper;
import org.example.mapper.ResourceMapper;
import org.example.mapper.RoleMapper;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

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
        // 根据roleId清空中间表
        roleMapper.deleteRoleContextMenu(roleId);
        roleMapper.deleteRole(roleId);
    }

    /**
     * 添加角色
     *
     * @param role
     */
    @Override
    public void saveRole(Role role) {
        role.setCreatedBy("system");
        role.setUpdatedBy("system");
        Date createdTime = new Date();
        role.setCreatedTime(createdTime);
        role.setUpdatedTime(createdTime);
        roleMapper.saveRole(role);
    }

    /**
     * 修改角色
     *
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        role.setUpdatedBy("system");
        role.setUpdatedTime(new Date());
        roleMapper.updateRole(role);
    }

    @Override
    public void allocateRoleContextResource(ResourceVO resourceVO) {
        Integer roleId = resourceVO.getRoleId();
        roleMapper.deleteRoleContextResourceByRoleId(roleId);
        List<Integer> resourceIdList = resourceVO.getResourceIdList();
        for (Integer resourceId : resourceIdList) {
            RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
            roleResourceRelation.setResourceId(resourceId);
            roleResourceRelation.setRoleId(roleId);

            roleResourceRelation.setCreatedBy("system");
            roleResourceRelation.setUpdatedBy("system");

            Date createdTime = new Date();
            roleResourceRelation.setCreatedTime(createdTime);
            roleResourceRelation.setUpdatedTime(createdTime);
            roleMapper.allocateRoleContextResource(roleResourceRelation);
        }
    }

    /**
     * 根据id查找角色拥有的资源分类和资源信息
     *
     * @param roleId
     * @return
     */
    @Override
    public List<ResourceCategory> findRoleHaveResource(Integer roleId) {
        // 1.获取资源分类数据
        List<ResourceCategory> resourceCategoryList = roleMapper.findRoleHaveResourceCategory(roleId);
        // 2.获取资源数据
        List<Resource> resourceList = roleMapper.findRoleHaveResource(roleId);

        // 3.封装资源到资源类
        for (ResourceCategory resourceCategory : resourceCategoryList) {
            for (Resource resource : resourceList) {
                // Integer类型用equals比较
                if (resource.getCategoryId().equals(resourceCategory.getId())) {
                    // 把同类型资源存到一个集合中
                    resourceCategory.getResourceList().add(resource);
                }
            }
        }
        return resourceCategoryList;
    }
}
