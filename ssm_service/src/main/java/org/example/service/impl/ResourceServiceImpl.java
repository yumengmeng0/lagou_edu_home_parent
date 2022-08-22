package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.domain.Resource;
import org.example.domain.ResourceVO;
import org.example.mapper.ResourceMapper;
import org.example.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 资源分页和多条件查询
     *
     * @param resourceVO
     * @return
     */
    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO) {
        PageHelper.startPage(resourceVO.getCurrentPage(), resourceVO.getPageSize());
        List<Resource> resourceList = resourceMapper.findAllResourceByPage(resourceVO);
        PageInfo<Resource> pageInfo = new PageInfo<>(resourceList);
        return pageInfo;
    }
}
