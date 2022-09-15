package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.domain.Resource;
import org.example.domain.ResourceVO;
import org.example.mapper.ResourceMapper;
import org.example.mapper.RoleMapper;
import org.example.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleMapper roleMapper;

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
        return new PageInfo<>(resourceList);
    }


    /**
     * 添加资源信息
     *
     * @param resourceVO
     */
    @Override
    public void saveResource(ResourceVO resourceVO) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceVO, resource);
        Date createdTime = new Date();
        resource.setCreatedTime(createdTime);
        resource.setUpdatedTime(createdTime);
        resource.setCreatedBy("system");
        resource.setUpdatedBy("system");
        resourceMapper.saveResource(resource);
    }

    /**
     * 更新资源信息
     *
     * @param resourceVO
     */
    @Override
    public void updateResource(ResourceVO resourceVO) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceVO, resource);
        System.out.println(resource);
        resource.setUpdatedTime(new Date());
        resource.setUpdatedBy("system");
        resourceMapper.updateResource(resource);
    }

    /**
     * 根据资源id查询资源信息
     *
     * @param id
     * @return
     */
    @Override
    public Resource findResourceById(Integer id) {
        return resourceMapper.findResourceById(id);
    }

    /**
     * 根据资源id删除资源信息
     *
     * @param id
     */
    @Override
    public void deleteResource(Integer id) {
        // 删除role_resource_relation中间表数据
        roleMapper.deleteRoleContextResource(id);
        resourceMapper.deleteResource(id);
    }
}
