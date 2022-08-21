package org.example.controller;

import org.example.domain.PromotionSpace;
import org.example.domain.ResponseResult;
import org.example.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/21
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/promotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace() {
        List<PromotionSpace> promotionSpaceList = promotionSpaceService.findAllPromotionSpace();
        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有广告位成功", promotionSpaceList);
        return responseResult;
    }

    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace) {
        ResponseResult responseResult = null;

        if (promotionSpace.getId() == null) {
            promotionSpaceService.savePromotionSpace(promotionSpace);
            responseResult = new ResponseResult(true, 200, "广告位添加成功", null);

        } else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            responseResult = new ResponseResult(true, 200, "广告位更新成功", null);
        }

        return responseResult;
    }

    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(@RequestParam("id") Integer id) {
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "根据id查询广告位成功", promotionSpace);
        return responseResult;
    }


}
