package org.example.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author
 */
@Data
public class RoleResourceRelation {

    private Integer id;
    private Integer resourceId;
    private Integer roleId;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;
}
