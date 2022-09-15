package org.example.domain;

import lombok.Data;

import java.util.List;

/**
 * @author
 */
@Data
public class RoleResourceVO {
    private Integer roleId;
    private List<Integer> resourceIdList;
}
