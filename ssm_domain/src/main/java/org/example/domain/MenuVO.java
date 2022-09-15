package org.example.domain;

import lombok.Data;

/**
 * MenuVO
 *
 * @author
 * @date 2022/9/15
 */

@Data
public class MenuVO {
    private Integer id;
    private Integer pageSize;
    private Integer currentPage;
}
