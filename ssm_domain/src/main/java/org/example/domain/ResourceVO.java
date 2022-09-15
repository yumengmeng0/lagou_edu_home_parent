package org.example.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author
 */
@Data
public class ResourceVO {
    private Integer id;
    private Integer roleId;
    private String name;
    private String url;
    private Integer categoryId;
    private String description;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;

    private Integer currentPage;
    private Integer pageSize;

    List<Integer> resourceIdList;
    List<Resource> resourceList;
}
