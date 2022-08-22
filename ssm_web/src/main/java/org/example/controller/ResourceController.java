package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.domain.Resource;
import org.example.domain.ResourceVO;
import org.example.domain.ResponseResult;
import org.example.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/22
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {


    @Autowired
    private ResourceService resourceService;

    /**
     * 资源分页和多条件查询
     *
     * @return
     */
    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource(@RequestBody ResourceVO resourceVO) {
        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVO);
        return new ResponseResult(true, 200, "资源信息分页多条件查询成功", pageInfo);
    }
}
