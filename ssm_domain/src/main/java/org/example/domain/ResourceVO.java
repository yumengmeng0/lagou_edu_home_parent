package org.example.domain;

import lombok.Data;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@Data
public class ResourceVO {
    private Integer currentPage;
    private Integer pageSize;
    private String name;
    private Integer categoryId;
    private String url;
}
