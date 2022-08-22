package org.example.service.impl;

import org.example.domain.Menu;
import org.example.mapper.MenuMapper;
import org.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
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
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
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
}
