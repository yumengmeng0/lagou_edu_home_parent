package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.domain.Resource;
import org.example.domain.ResourceVO;
import org.example.domain.ResponseResult;
import org.example.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 资源管理
 *
 * @author
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    /**
     * 资源分页和多条件查询
     * \@RequestBody 请求post为json格式的对象是，用此注解注释，将前端对象映射到后端
     *
     * @return
     */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO) {
        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVO);
        return new ResponseResult(true, 200, "资源信息分页多条件查询成功", pageInfo);
    }

    /**
     * 添加&更新资源信息
     *
     * @param resourceVO
     * @return
     */
    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody ResourceVO resourceVO) {
        if (resourceVO.getId() != null) {
            resourceService.updateResource(resourceVO);
            return new ResponseResult(true, 200, "更新资源信息成功", null);
        } else {
            resourceService.saveResource(resourceVO);
            return new ResponseResult(true, 200, "添加资源信息成功", null);
        }
    }

    /**
     * 根据资源 id 查询资源信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/findResourceById")
    public ResponseResult findResourceById(@RequestParam("id") Integer id) {
        Resource resource = resourceService.findResourceById(id);
        ResourceVO resourceVO = new ResourceVO();
        BeanUtils.copyProperties(resource, resourceVO);
        return new ResponseResult(true, 200, "查询资源信息成功", resourceVO);
    }

    /**
     * 根据资源id删除资源信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(@RequestParam("id") Integer id) {
        resourceService.deleteResource(id);
        return new ResponseResult(true, 200, "删除资源信息成功", null);
    }

}
