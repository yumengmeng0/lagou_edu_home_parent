package org.example.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RoleMenuRelation {
    private Integer id;
    private Integer menuId;
    private Integer roleId;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;
}
