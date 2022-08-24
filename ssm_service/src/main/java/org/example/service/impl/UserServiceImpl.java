package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.domain.*;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.example.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户分页多条件组合查询
     *
     * @param userVO
     * @return
     */
    @Override
    public PageInfo<User> findAllUserByPage(UserVO userVO) {
        PageHelper.startPage(userVO.getCurrentPage(), userVO.getPageSize());
        List<User> userList = userMapper.findAllUserByPage(userVO);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
     * 用户登录（根据用户名查询具体用户信息）
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) throws Exception {
        User user1 = userMapper.login(user);
        if (user1 != null && Md5.verify(user.getPassword(), "lagou", user1.getPassword())) {
            return user1;
        }
        return null;
    }

    /**
     * 根据用户id查询关联的角色信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<Role> findUserRelationRoleById(Integer userId) {
        return userMapper.findUserRelationRoleById(userId);
    }

    /**
     * 分配角色
     *
     * @param userVO
     */
    @Override
    public void userContextRole(UserVO userVO) {
        Integer userId = userVO.getUserId();
        userMapper.deleteUserContextRole(userId);
        Date createdTime = new Date();

        for (Integer roleId : userVO.getRoleIdList()) {
            UserRoleRelation userRoleRelation = new UserRoleRelation();
            userRoleRelation.setUserId(userId);
            userRoleRelation.setRoleId(roleId);
            userRoleRelation.setCreatedBy("system");
            userRoleRelation.setUpdatedBy("system");
            userRoleRelation.setCreatedTime(createdTime);
            userRoleRelation.setUpdatedTime(createdTime);

            userMapper.userContextRole(userRoleRelation);
        }

    }

    @Override
    public ResponseResult getUserPermissions(Integer userId) {
        // 1.获取当前用户拥有的所有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(userId);
        // 2.获取角色id保存到list中
        ArrayList<Integer> roleIds = new ArrayList<>();
        for (Role role : roleList) {
            roleIds.add(role.getId());
        }
        // 3.根据角色id查询父菜单
        List<Menu> parentMenuList = userMapper.findParentMenuByRoleId(roleIds);
        // 4.封装父菜单封装的子菜单
        for (Menu menu : parentMenuList) {
            List<Menu> subMenuList = userMapper.findSubMenuByParentId(menu.getId());
            menu.setSubMenuList(subMenuList);
        }
        // 5.获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        // 6.封装数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("menuList", parentMenuList);
        map.put("resourceList", resourceList);
        return new ResponseResult(true, 200, "获取用户权限信息成功", map);
    }


}
