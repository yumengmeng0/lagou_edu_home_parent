package org.example.mapper;

import org.example.domain.User;
import org.example.domain.UserVO;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
public interface UserMapper {

    /**
     * 用户分页多条件组合查询
     *
     * @return
     */
    List<User> findAllUserByPage(UserVO userVO);
}
