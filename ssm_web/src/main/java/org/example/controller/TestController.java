package org.example.controller;

import org.example.domain.Test;
import org.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/8/16
 * @version: 1.0.0
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/findAll")
    public List<Test> findAll() {
        List<Test> testList = testService.findAll();
        return testList;
    }

}
