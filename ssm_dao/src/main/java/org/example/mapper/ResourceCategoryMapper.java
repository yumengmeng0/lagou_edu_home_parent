package org.example.mapper;

import org.example.domain.ResourceCategory;

import java.util.List;

/**
 * @author:
 */
public interface ResourceCategoryMapper {

    /**
     * 查询所有资源分类
     *
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();

    /**
     * 根据资源分类id查找资源分类
     *
     * @param id
     * @return
     */
    ResourceCategory findResourceCategoryById(Integer id);

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
     * @param id
     */
    void deleteResourceCategoryById(Integer id);

    /**
     * 根据资源分类id查找资源id列表
     *
     * @param categoryId
     * @return
     */
    List<Integer> findAllResourceIdByCategoryByCategoryId(Integer categoryId);

}
