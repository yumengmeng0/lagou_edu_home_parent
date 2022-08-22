package org.example.mapper;

import org.example.domain.Menu;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
public interface MenuMapper {

    /**
     * 查询所有父子菜单信息
     *
     * @return
     */
    List<Menu> findSubMenuByPid(Integer id);

    /**
     * 查询所有菜单
     *
     * @return
     */
    List<Menu> findAllMenu();

    /**
     * 根据id查找菜单项
     *
     * @param id
     * @return
     */
    Menu findMenuById(Integer id);
}
