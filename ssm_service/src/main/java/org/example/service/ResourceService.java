package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.Resource;
import org.example.domain.ResourceVO;

/**
 * @author
 */
public interface ResourceService {

    /**
     * 资源分页和多条件查询
     *
     * @param resourceVO
     * @return
     */
    PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO);

    /**
     * 添加资源信息
     *
     * @param resourceVO
     */
    void saveResource(ResourceVO resourceVO);

    /**
     * 更新资源信息
     *
     * @param resourceVO
     */
    void updateResource(ResourceVO resourceVO);

    /**
     * 根据资源 id 查询资源信息
     *
     * @param id
     * @return
     */
    Resource findResourceById(Integer id);

    /**
     * 根据资源id删除资源信息
     *
     * @param id
     */
    void deleteResource(Integer id);


}
