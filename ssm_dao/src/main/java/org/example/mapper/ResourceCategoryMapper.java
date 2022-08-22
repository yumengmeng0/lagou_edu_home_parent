package org.example.mapper;

import org.example.domain.ResourceCategory;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
public interface ResourceCategoryMapper {

    /**
     * 查询所有资源分类
     *
     * @return
     */
    List<ResourceCategory> findAllResourceCategory();
}
