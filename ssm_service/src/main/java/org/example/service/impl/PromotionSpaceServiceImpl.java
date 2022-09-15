package org.example.service.impl;

import org.example.domain.PromotionSpace;
import org.example.mapper.PromotionSpaceMapper;
import org.example.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author
 */

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    /**
     * 获取所有广告位
     *
     * @return
     */
    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    /**
     * 添加广告位
     *
     * @param promotionSpace
     */
    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date createTime = new Date();
        promotionSpace.setCreateTime(createTime);
        promotionSpace.setUpdateTime(createTime);
        promotionSpace.setIsDel(0);
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    /**
     * 更新广告位
     *
     * @param promotionSpace
     */
    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        Date createTime = new Date();
        promotionSpace.setUpdateTime(createTime);
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }

    /**
     * 根据id查询广告位信息
     *
     * @param id
     * @return
     */
    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }
}
