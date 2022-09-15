package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.PromotionAd;
import org.example.domain.PromotionAdVO;

/**
 * @author
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

    /**
     * 根据广告id查询广告信息
     *
     * @param id
     * @return
     */
    PromotionAd findPromotionAdById(Integer id);

    /**
     * 保存广告
     *
     * @param promotionAd
     */
    void savePromotionAd(PromotionAd promotionAd);

    /**
     * 修改广告
     *
     * @param promotionAd
     */
    void updatePromotionAd(PromotionAd promotionAd);
}
