package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.User;
import org.example.domain.UserVO;


/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
public interface UserService {

    /**
     * 用户分页多条件组合查询
     *
     * @return
     */
    PageInfo<User> findAllUserByPage(UserVO userVO);
}
