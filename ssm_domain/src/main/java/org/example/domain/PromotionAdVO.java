package org.example.domain;

import lombok.Data;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
@Data
public class PromotionAdVO {
    // 当前页
    private Integer currentPage;
    // 每页显示条数
    private Integer pageSize;
}
