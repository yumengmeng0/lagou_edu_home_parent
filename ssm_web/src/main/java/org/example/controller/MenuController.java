package org.example.controller;

import com.github.pagehelper.PageInfo;
import lombok.Setter;
import org.example.domain.Menu;
import org.example.domain.MenuVO;
import org.example.domain.ResponseResult;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * 菜单
 *
 * @author
 */
@RestController
@RequestMapping("/menu")
@Setter(onMethod_ = {@Autowired})
public class MenuController {

//    @Autowired
    /**
     *
     */
    private MenuService menuService;

    /**
     * 查询所有菜单
     *
     * @return
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(MenuVO menuVO) {
        PageInfo pageInfo = menuService.findAllMenu(menuVO);
        return new ResponseResult(true, 200, "查询所有菜单成功", pageInfo);
    }


    /**
     * @param id
     * @return
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(@RequestParam("id") Integer id) {

        HashMap<String, Object> map = new HashMap<>(2);

        // id为-1时是新增操作，否则是修改
        if (id == -1) {
            map.put("menuInfo", null);
            // 查找顶级菜单
            List<Menu> menuList = menuService.findSubMenuByPid(-1);
            map.put("parentMenuList", menuList);
            return new ResponseResult(true, 200, "查询添加回显成功", map);
        } else {
            Menu menu = menuService.findMenuById(id);
            map.put("menuInfo", menu);
            List<Menu> menuList = menuService.findSubMenuByPid(menu.getParentId());
            map.put("parentMenuList", menuList);
            return new ResponseResult(true, 200, "查询修改回显成功", map);
        }
    }

    @RequestMapping("/saveOrUpdateMenu")
    public ResponseResult saveOrUpdateMenu(@RequestBody Menu menu) {
        if (menu.getId() != null) {
            menuService.updateMenu(menu);
            return new ResponseResult(true, 200, "修改菜单成功", null);
        } else {
            menuService.saveMenu(menu);
            return new ResponseResult(true, 200, "保存菜单成功", null);
        }
    }

    @RequestMapping("/deleteMenu")
    public ResponseResult deleteMenu(@RequestParam("id") Integer id) {
        menuService.deleteMenu(id);
        return new ResponseResult(true, 200, "删除菜单成功", null);
    }
}
