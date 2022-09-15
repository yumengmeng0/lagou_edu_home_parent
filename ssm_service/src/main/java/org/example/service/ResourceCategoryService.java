package org.example.service;

import org.example.domain.ResourceCategory;

import java.util.List;

/**
 * @author
 */
public interface ResourceCategoryService {

    /**
     * 查询所有资源分类
     *
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();

    /**
     * 添加资源分类
     *
     * @param resourceCategory
     */
    void saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 修改资源分类
     *
     * @param resourceCategory
     */
    void updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 根据资源分类id删除资源分类
     *
     * @param categoryId
     */
    void deleteResourceCategoryById(Integer categoryId);
}
