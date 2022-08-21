package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.domain.User;
import org.example.domain.UserVO;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
        List<User> userList = userMapper.findAllUserByPage(userVO);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
