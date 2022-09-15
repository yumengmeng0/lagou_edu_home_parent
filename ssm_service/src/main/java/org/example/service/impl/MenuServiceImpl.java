package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.domain.Menu;
import org.example.domain.MenuVO;
import org.example.mapper.MenuMapper;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询所有父子菜单信息
     *
     * @param id
     * @return
     */
    @Override
    public List<Menu> findSubMenuByPid(Integer id) {
        return menuMapper.findSubMenuByPid(id);
    }

    /**
     * 查询所有菜单
     *
     * @return
     */
    @Override
    public PageInfo<Menu> findAllMenu(MenuVO menuVO) {
        PageHelper.startPage(menuVO.getCurrentPage(), menuVO.getPageSize());
        List<Menu> menuList = menuMapper.findAllMenu();
        PageInfo<Menu> pageInfo = new PageInfo<>(menuList);
        return pageInfo;
    }

    /**
     * 根据id查找菜单项
     *
     * @param id
     * @return
     */
    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }

    /**
     * 添加菜单
     *
     * @param menu
     */
    @Override
    public void saveMenu(Menu menu) {
        Date createdTime = new Date();
        menu.setCreatedTime(createdTime);
        menu.setUpdatedTime(createdTime);
        menu.setCreatedBy("system");
        menu.setUpdatedBy("system");
        if (menu.getParentId() == -1) {
            menu.setLevel(0);
        } else {
            menu.setLevel(1);
        }
        menuMapper.saveMenu(menu);
    }

    /**
     * 更新菜单
     *
     * @param menu
     */
    @Override
    public void updateMenu(Menu menu) {
        menu.setUpdatedTime(new Date());
        menu.setUpdatedBy("system");
        if (menu.getParentId() == -1) {
            menu.setLevel(0);
        } else {
            menu.setLevel(1);
        }
        menuMapper.updateMenu(menu);
    }

    /**
     * 根据菜单id删除角色和菜单的中间表
     *
     * @param id
     */
    @Override
    public void deleteMenu(Integer id){
        menuMapper.deleteRoleContextMenuByMenuId(id);
        menuMapper.deleteMenu(id);
    }


}
