package org.example.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@Data
public class RoleMenuVO {
    private Integer roleId;
    private List<Integer> menuIdList;
}
