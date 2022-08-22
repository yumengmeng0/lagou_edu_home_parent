package org.example.controller;

import org.example.domain.*;
import org.example.service.MenuService;
import org.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

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
        List<Menu> menuList = menuService.findSubMenuByPid(-1); // -1 表示查询所有父级菜单
        HashMap<String, Object> map = new HashMap<>();
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
}

