package org.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PromotionAd {

    // 标识
    private Integer id;
    // 广告名
    private String name;
    // 广告位id
    private Integer spaceId;
    // 精确搜索关键词
    private String keyword;
    // 静态广告的内容
    private String htmlContent;
    // 文字一
    private String text;
    // 链接一
    private String link;
    // 开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    // 结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    // 优先级
    private Integer priority;
    private String img;

    // 广告位
    private PromotionSpace promotionSpace;
}
