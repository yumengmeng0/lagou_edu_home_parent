package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.domain.Resource;
import org.example.domain.ResourceVO;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
public interface ResourceService {

    /**
     * 资源分页和多条件查询
     *
     * @return
     */
    PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
