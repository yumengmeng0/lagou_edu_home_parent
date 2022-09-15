package org.example.domain;

import lombok.Data;

import java.util.Date;

/**
 * 角色类
 *
 * @author
 */
@Data
public class Role {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;
}
