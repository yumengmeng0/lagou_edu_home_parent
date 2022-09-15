package org.example.controller;

import org.example.domain.ResourceCategory;
import org.example.domain.ResponseResult;
import org.example.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 资源分类
 *
 * @author
 */
@RestController
@RequestMapping("/resourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    /**
     * 获取所有资源分类
     *
     * @return
     */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory() {
        List<ResourceCategory> resourceCategoryList = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(true, 200, "查询所有资源分类成功", resourceCategoryList);
    }

    /**
     * 添加&更新资源分类信息
     */
    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory) {
        if (resourceCategory.getId() == null) {
            resourceCategoryService.saveResourceCategory(resourceCategory);
            return new ResponseResult(true, 200, "添加资源分类信息成功", null);
        } else {
            resourceCategoryService.updateResourceCategory(resourceCategory);
            return new ResponseResult(true, 200, "更新资源分类信息成功", null);
        }
    }

    @RequestMapping("/deleteResourceCategoryById")
    public ResponseResult deleteResourceCategoryById(@RequestParam("categoryId") Integer categoryId) {
        resourceCategoryService.deleteResourceCategoryById(categoryId);
        return new ResponseResult(true, 200, "删除资源分类信息成功", null);
    }
}
