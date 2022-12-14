package org.example.service;

import org.example.domain.PromotionSpace;

import java.util.List;

/**
 * @author
 */
public interface PromotionSpaceService {

    /**
     * 获取所有广告位
     *
     * @return
     */
    List<PromotionSpace> findAllPromotionSpace();

    /**
     * 添加广告位
     *
     * @param promotionSpace
     */
    void savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 更新广告位
     *
     * @param promotionSpace
     */
    void updatePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 根据id查询广告位信息
     *
     * @param id
     * @return
     */
    PromotionSpace findPromotionSpaceById(Integer id);
}
