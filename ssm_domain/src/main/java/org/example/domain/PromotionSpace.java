package org.example.domain;

import lombok.Data;

import java.util.Date;

/**
 * 广告位
 *
 * @author
 */
@Data
public class PromotionSpace {
    private Integer id;
    private String name;
    private String spaceKey;
    private Date createTime;
    private Date updateTime;
    private Integer isDel;
}
