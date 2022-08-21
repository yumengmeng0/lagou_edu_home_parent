package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.domain.PromotionAd;
import org.example.domain.PromotionAdVO;
import org.example.mapper.PromotionAdMapper;
import org.example.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    /**
     * 分页查询广告信息
     *
     * @return
     */
    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {
        PageHelper.startPage(promotionAdVO.getCurrentPage(), promotionAdVO.getPageSize());
        List<PromotionAd> promotionAdList = promotionAdMapper.findAllPromotionAdByPage();
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(promotionAdList);
        return pageInfo;
    }

    /**
     * 广告上下线
     *
     * @param id
     * @param status
     */
    @Override
    public void updatePromotionAdStatus(Integer id, Integer status) {
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        Date updateTime = new Date();
        promotionAd.setUpdateTime(updateTime);
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }

}
