package org.example.mapper;

import org.example.domain.PromotionAd;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
public interface PromotionAdMapper {

    /**
     * 分页查询广告信息
     *
     * @return
     */
    List<PromotionAd> findAllPromotionAdByPage();


    /**
     * 广告上下线
     * @param promotionAd
     */
    void updatePromotionAdStatus(PromotionAd promotionAd);

}
