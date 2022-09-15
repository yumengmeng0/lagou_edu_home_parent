package org.example.mapper;

import org.example.domain.Resource;
import org.example.domain.ResourceVO;

import java.util.List;


/**
 * @author
 */
public interface ResourceMapper {

    /**
     * 资源分页和多条件查询
     *
     * @param resourceVO
     * @return
     */
    List<Resource> findAllResourceByPage(ResourceVO resourceVO);

    /**
     * 添加资源信息
     *
     * @param resource
     */
    void saveResource(Resource resource);

    /**
     * 更新资源信息
     *
     * @param resource
     */
    void updateResource(Resource resource);

    /**
     * 根据资源分类id删除资源
     *
     * @param resourceCategoryId
     */
    void deleteResourceByResourceCategoryId(Integer resourceCategoryId);

    /**
     * 根据资源id删除关联表
     *
     * @param ids
     */
    void deleteRoleContextResource(List<Integer> ids);


    /**
     * 根据资源分类id查询分类下所有资源
     *
     * @param categoryId
     * @return
     */
    List<Resource> findResourceByeCategoryId(Integer categoryId);

    /**
     * 根据资源 id 查询资源信息
     *
     * @param id
     * @return
     */
    Resource findResourceById(Integer id);

    /**
     * 根据资源id删除资源
     *
     * @param id
     * @return
     */
    void deleteResource(Integer id);



}
