package org.example.mapper;

import org.example.domain.PromotionAd;

import java.util.List;

/**
 * @author
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
     *
     * @param promotionAd
     */
    void updatePromotionAdStatus(PromotionAd promotionAd);

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
