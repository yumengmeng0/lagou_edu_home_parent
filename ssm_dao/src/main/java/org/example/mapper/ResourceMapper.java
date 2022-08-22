package org.example.mapper;

import org.example.domain.Resource;
import org.example.domain.ResourceVO;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
public interface ResourceMapper {

    /**
     * 资源分页和多条件查询
     *
     * @return
     */
    List<Resource> findAllResourceByPage(ResourceVO resourceVO);


}
