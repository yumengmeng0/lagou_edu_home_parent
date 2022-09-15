package org.example.controller;

import org.example.domain.PromotionSpace;
import org.example.domain.ResponseResult;
import org.example.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 广告位
 *
 * @author
 */
//@CrossOrigin
@RestController
@RequestMapping("/promotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    /**
     * 查询所有广告位
     *
     * @return
     */
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace() {
        List<PromotionSpace> promotionSpaceList = promotionSpaceService.findAllPromotionSpace();
        return new ResponseResult(true, 200, "查询所有广告位成功", promotionSpaceList);
    }

    /**
     * 添加或更新广告位
     *
     * @param promotionSpace
     * @return
     */
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace) {
        System.out.println("promotionSpace = " + promotionSpace);

        if (promotionSpace.getId() == null) {
            promotionSpaceService.savePromotionSpace(promotionSpace);
            return new ResponseResult(true, 200, "广告位添加成功", null);

        } else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            return new ResponseResult(true, 200, "广告位更新成功", null);
        }
    }

    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(@RequestParam("id") Integer id) {
        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);
        return new ResponseResult(true, 200, "根据id查询广告位成功", promotionSpace);
    }

}
