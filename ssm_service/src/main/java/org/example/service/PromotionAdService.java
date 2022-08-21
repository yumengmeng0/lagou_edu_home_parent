package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.PromotionAd;
import org.example.domain.PromotionAdVO;


/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
public interface PromotionAdService {

    /**
     * 分页查询广告信息
     *
     * @return
     */
    PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);


    /**
     * 广告上下线
     *
     * @param id
     * @param status
     */
    void updatePromotionAdStatus(Integer id, Integer status);
}
