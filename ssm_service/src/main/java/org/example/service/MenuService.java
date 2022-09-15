package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.Menu;
import org.example.domain.MenuVO;

import java.util.List;

/**
 * @author
 */
public interface MenuService {

    /**
     * 查询所有父子菜单信息
     *
     * @param id 父级菜单id
     * @return
     */
    List<Menu> findSubMenuByPid(Integer id);

    /**
     * 查询所有菜单
     *
     * @param menuVO
     * @return
     */
    PageInfo findAllMenu(MenuVO menuVO);

    /**
     * 根据id查找菜单项
     *
     * @param id
     * @return
     */
    Menu findMenuById(Integer id);

    /**
     * 添加菜单
     * @param menu
     */
    void saveMenu(Menu menu);

    /**
     * 更新菜单
     * @param menu
     */
    void updateMenu(Menu menu);

    /**
     * 根据菜单id删除角色和菜单的中间表
     *
     * @param id
     */
     void deleteMenu(Integer id);
}
