package org.example.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 资源分类类
 *
 * @author
 */
@Data
public class ResourceCategory {
    private Integer id;
    private String name;
    private Integer sort;
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;

    private List<Resource> resourceList = new ArrayList<>();
}
