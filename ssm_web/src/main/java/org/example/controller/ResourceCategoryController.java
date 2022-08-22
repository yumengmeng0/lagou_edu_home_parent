package org.example.controller;

import org.example.domain.ResourceCategory;
import org.example.domain.ResponseResult;
import org.example.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory() {
        List<ResourceCategory> resourceCategoryList = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(true, 200, "查询所有资源分类成功", resourceCategoryList);
    }
}
