package org.example.domain;

import lombok.Data;

import java.util.List;


/**
 * @author
 */
@Data
public class RoleMenuVO {
    private Integer roleId;
    private List<Integer> menuIdList;
}
