package org.example.controller;

import org.example.domain.Menu;
import org.example.domain.ResponseResult;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有菜单
     *
     * @return
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu() {
        List<Menu> menuList = menuService.findAllMenu();
        return new ResponseResult(true, 200, "查询所有菜单成功", menuList);
    }


    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(@RequestParam("id") Integer id) {

        // id为-1时是新增操作，否则是修改
        if (id == -1) {
            List<Menu> menuList = menuService.findSubMenuByPid(id);
            HashMap<String, Object> map = new HashMap<>();
            map.put("menuInfo", null);
            map.put("parentMenuList", menuList);
            return new ResponseResult(true, 200, "查询添加回显成功", map);
        } else {
            List<Menu> menuList = menuService.findSubMenuByPid(id);
            HashMap<String, Object> map = new HashMap<>();
            Menu menu = menuService.findMenuById(id);
            map.put("menuInfo", menu);
            map.put("parentMenuList", menuList);
            return new ResponseResult(true, 200, "查询修改回显成功", map);
        }

    }

}
