package org.example.controller;

import org.example.domain.*;
import org.example.service.MenuService;
import org.example.service.ResourceService;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * 角色管理
 *
 * @author
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 按条件查询所有角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role) {
        return new ResponseResult(true, 200, "查询所有角色成功", roleService.findAllRole(role));
    }

    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuByPid() {
        // -1 表示查询所有父级菜单
        List<Menu> menuList = menuService.findSubMenuByPid(-1);
        HashMap<String, Object> map = new HashMap<>(menuList.size());
        map.put("parentMenuList", menuList);
        return new ResponseResult(true, 200, "查询父子级菜单成功", map);
    }

    /**
     * 根据角色id查询该角色关联菜单信息的id
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(@RequestParam("roleId") Integer roleId) {
        List<Integer> menuIdList = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(true, 200, "查询角色关联菜单成功", menuIdList);
    }

    /**
     * 为角色分配菜单
     *
     * @return
     */
    @RequestMapping("/roleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVO roleMenuVO) {
        roleService.allocateRoleContextMenu(roleMenuVO);
        return new ResponseResult(true, 200, "为角色分配菜单成功", null);
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(@RequestParam("id") Integer id) {
        roleService.deleteRole(id);
        return new ResponseResult(true, 200, "删除角色成功", null);
    }

    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role) { // @RequestBody post请求是json
        System.out.println("role = " + role);
        if (role.getId() == null) {
            roleService.saveRole(role);
            return new ResponseResult(true, 200, "添加角色成功", "");
        } else {
            roleService.updateRole(role);
            return new ResponseResult(true, 200, "修改角色成功", "");
        }
    }

    /**
     * 根据角色id查询的分配资源
     *
     * @return
     */
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(@RequestParam("roleId") Integer roleId) {
        List<ResourceCategory> resourceCategoryList = roleService.findRoleHaveResource(roleId);
        return new ResponseResult(true, 200, "查询的分配资源成功", resourceCategoryList);
    }

    /**
     * 分配资源
     *
     * @return
     */
    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody ResourceVO resourceVO) {
        roleService.allocateRoleContextResource(resourceVO);
        return new ResponseResult(true, 200, "分配资源成功", null);
    }


}

