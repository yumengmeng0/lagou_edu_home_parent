package org.example.domain;

import lombok.Data;


/**
 * @author
 */
@Data
public class PromotionAdVO {
    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 每页显示条数
     */
    private Integer pageSize;
}
