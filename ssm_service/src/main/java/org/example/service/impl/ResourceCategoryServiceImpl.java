package org.example.service.impl;

import org.example.domain.Resource;
import org.example.domain.ResourceCategory;
import org.example.mapper.ResourceCategoryMapper;
import org.example.mapper.ResourceMapper;
import org.example.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询所有资源分类
     *
     * @return
     */
    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }

    /**
     * 添加资源分类
     *
     * @param resourceCategory
     */
    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {
        Date createdTime = new Date();
        resourceCategory.setCreatedTime(createdTime);
        resourceCategory.setUpdatedTime(createdTime);
        resourceCategory.setCreatedBy("system");
        resourceCategory.setUpdatedBy("system");
        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    /**
     * 修改资源分类
     *
     * @param resourceCategory
     */
    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {
        resourceCategory.setUpdatedTime(new Date());
        resourceCategory.setUpdatedBy("system");
        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    @Override
    public void deleteResourceCategoryById(Integer categoryId) {
        List<Resource> resourceList = resourceMapper.findResourceByeCategoryId(categoryId);

        System.out.println(resourceList);
        if (resourceList.size() != 0) {
            ArrayList<Integer> ids = new ArrayList<>();
            for (Resource resource : resourceList) {
                Integer id = resource.getId();
                ids.add(id);
            }
            resourceMapper.deleteRoleContextResource(ids);
        }
        resourceCategoryMapper.deleteResourceCategoryById(categoryId);
    }
}
